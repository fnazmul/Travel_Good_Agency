/*
 * 
 * 
 */
package WEBSERVICE;

import javax.jws.WebService;
import javax.xml.ws.WebServiceRef;
import ws.cheapbird.CheapBirdPortType;

import DATABASE.CheapBirdDummyData;
import ws.airlinereservation.types.FlightInfo;
import ws.airlinereservation.types.FlightList;
import dk.dtu.imm.fastmoney.CreditCardFaultMessage;
import dk.dtu.imm.fastmoney.types.AccountType;
import dk.dtu.imm.fastmoney.types.CreditCardInfoType;

import dk.dtu.imm.fastmoney.types.ExpirationDateType;
import ws.plantrip.CallbackPlanTripService;
import ws.travelgood.types.Flight;

/**
 *
 * @author 
 */
@WebService(serviceName = "CheapBirdService",
    portName = "CheapBirdPort",
    endpointInterface = "ws.cheapbird.CheapBirdPortType",
    targetNamespace = "urn://cheapbird.ws",
    wsdlLocation = "WEB-INF/wsdl/CheapBird/CheapBirdWrapper.wsdl")
    
public class CheapBird implements CheapBirdPortType {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/client/PlanTrip/PlanTrip.wsdl")
    private CallbackPlanTripService service;

    //declare plantrip call back service

    //create the dummy database
    private CheapBirdDummyData flightDatabase = new CheapBirdDummyData();
    // create the bank account type
    private dk.dtu.imm.fastmoney.types.AccountType account = new AccountType();

    public void getFlights(ws.airlinereservation.types.SearchFlight searchFlight,
            java.lang.String sessionID) {
        // search in the dummy database
        FlightList findList = flightDatabase.getFlightList(searchFlight);
        //System.out.println(findList.getFlightInfo().get(0).getBookingNo());
        //call back hotelList of travel agency

        try { // Call Web Service Operation
            ws.plantrip.CallbackPlanTripPortType port =
                    service.getCallbackPlanTripPortTypeBindingPort();
            // initialize WS operation arguments here
            ws.travelgood.types.FlightList flightListCheapBird =
                    new ws.travelgood.types.FlightList();
            port.flightListCheapBird(sessionID, flightListCheapBird);

            for (FlightInfo flightInfo : findList.getFlightInfo()) {
                ws.travelgood.types.FlightInfo newFlightInfo =
                        new ws.travelgood.types.FlightInfo();
                ws.travelgood.types.Flight newFlight =
                        new Flight();

                newFlight.setFrom(flightInfo.getFlight().getFrom());
                newFlight.setTo(flightInfo.getFlight().getTo());
                newFlight.setCarrier(flightInfo.getFlight().getCarrier());
                newFlight.setDepartureDate(flightInfo.getFlight().getDepartureDate());
                newFlight.setArrivalDate(flightInfo.getFlight().getArrivalDate());

                newFlightInfo.setFlight(newFlight);
                newFlightInfo.setBookingNo(flightInfo.getBookingNo());
                newFlightInfo.setPrice(flightInfo.getPrice());
                newFlightInfo.setReservationService(flightInfo.getReservationService());

                flightListCheapBird.getFlightInfo().add(newFlightInfo);
            }
        } catch (Exception ex) {
            // handle custom exceptions here
            System.out.println(ex.getMessage());
        }


    }

    public boolean bookFlight(java.lang.String bookingNo,
            ws.airlinereservation.types.CreditCardInfoType creditCardInfo) {
        FlightInfo flightInfo = flightDatabase.getFlight(bookingNo);

        if (flightInfo != null) {
            //call chargeCreditCard of bankService
            try {
                /// Create the Web Service port
                dk.dtu.imm.fastmoney.BankService service =
                        new dk.dtu.imm.fastmoney.BankService();
                dk.dtu.imm.fastmoney.BankPortType port = service.getBankPort();

                // initialize WS operation arguments
                int group = 10;
                int amount = (int) (flightInfo.getPrice());

                dk.dtu.imm.fastmoney.types.ExpirationDateType cardDate =
                        new ExpirationDateType();
                cardDate.setMonth(creditCardInfo.getExpirationDate().getMonth());
                cardDate.setYear(creditCardInfo.getExpirationDate().getYear());

                dk.dtu.imm.fastmoney.types.CreditCardInfoType cardInfo =
                        new CreditCardInfoType();
                cardInfo.setExpirationDate(cardDate);
                cardInfo.setName(creditCardInfo.getName());
                cardInfo.setNumber(creditCardInfo.getNumber());

                //dk.dtu.imm.fastmoney.types.AccountType account = new AccountType();
                account.setName("CheapBird");
                account.setNumber("50208813");

                //try {
                boolean status = port.chargeCreditCard(group, cardInfo,
                        amount, account);
                return status;
            } catch (CreditCardFaultMessage fault) {
                System.out.println("Fault Message : "
                        + fault.getFaultInfo().getMessage());
                return false;
            } catch (Exception ex) {
                System.out.println("Error Message : " + ex.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean cancelFlight(java.lang.String bookingNo, 
            ws.airlinereservation.types.CreditCardInfoType creditCardInfo) {

        FlightInfo flightInfo = flightDatabase.getFlight(bookingNo);

        if (flightInfo != null) {
            //call chargeCreditCard of bankService
            try {
                /// Create the Web Service port
                dk.dtu.imm.fastmoney.BankService service =
                        new dk.dtu.imm.fastmoney.BankService();
                dk.dtu.imm.fastmoney.BankPortType port = service.getBankPort();
                // initialize WS operation arguments
                int group = 10;
                int refundAmount = (int) (flightInfo.getPrice() / 2);
                account.setName("CheapBird");
                account.setNumber("50208813");

                dk.dtu.imm.fastmoney.types.ExpirationDateType cardDate =
                        new ExpirationDateType();
                cardDate.setMonth(creditCardInfo.getExpirationDate().getMonth());
                cardDate.setYear(creditCardInfo.getExpirationDate().getYear());

                dk.dtu.imm.fastmoney.types.CreditCardInfoType cardInfo =
                        new CreditCardInfoType();
                cardInfo.setExpirationDate(cardDate);
                cardInfo.setName(creditCardInfo.getName());
                cardInfo.setNumber(creditCardInfo.getNumber());

                boolean status = port.refundCreditCard(group, cardInfo,
                        refundAmount, account);
                return status;
            } catch (CreditCardFaultMessage fault) {
                System.out.println("Fault Message : "
                        + fault.getFaultInfo().getMessage());
                return false;
            } catch (Exception ex) {
                System.out.println("Error Message : " + ex.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }
}
