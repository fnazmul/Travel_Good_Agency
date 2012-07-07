/*
 * 
 * 
 */
package WEBSERVICE;

import DATABASE.HotelDummyData;
import javax.xml.ws.WebServiceRef;
import ws.niceview.types.Hotel;
import ws.niceview.types.HotelList;
import dk.dtu.imm.fastmoney.CreditCardFaultMessage;

import javax.jws.WebService;
import ws.niceview.NiceViewPortType;
import ws.plantrip.CallbackPlanTripService;

/**
 *
 * @author 
 */

@WebService(serviceName = "NiceViewService", 
        portName = "NiceViewPort",
        endpointInterface = "ws.niceview.NiceViewPortType",
        targetNamespace = "urn://niceview.ws",
        wsdlLocation = "WEB-INF/wsdl/NiceView/NiceView.wsdl")
public class NiceView implements NiceViewPortType {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/client/PlanTrip/PlanTrip.wsdl")
    private CallbackPlanTripService service;
    
    //declare plantrip call back service

    
    //create the dummy database
    private HotelDummyData hotelDatabase = new HotelDummyData();


    public void getHotels(ws.niceview.types.SearchHotel searchInfo,
            java.lang.String sessionID) {

        // search in the dummy database
        HotelList hotelList = hotelDatabase.getHotels(searchInfo);
        //System.out.println(hotelList.getHotelList().get(0).getHotelName());

        //call back hotelList of travel agency
        try { // Call Web Service Operation
            ws.plantrip.CallbackPlanTripPortType port =
                    service.getCallbackPlanTripPortTypeBindingPort();
            // initialize WS operation arguments here
            ws.travelgood.types.HotelList hotelListNiceView =
                    new ws.travelgood.types.HotelList();
            for(Hotel hotel: hotelList.getHotelList()){
                ws.travelgood.types.Hotel newHotel =
                        new ws.travelgood.types.Hotel();
                ws.travelgood.types.HotelAddress newHotelAddress =
                        new ws.travelgood.types.HotelAddress();

                newHotel.setHotelName(hotel.getHotelName());
                newHotel.setHotelBookingNo(hotel.getHotelBookingNo());
                newHotel.setHotelCreditGurantee(hotel.isHotelCreditGurantee());
                newHotel.setHotelPrice(hotel.getHotelPrice());
                newHotel.setHotelReservationService(hotel.getHotelReservationService());

                newHotelAddress.setCity(hotel.getHotelAddress().getCity());
                newHotelAddress.setStreet(hotel.getHotelAddress().getStreet());

                newHotel.setHotelAddress(newHotelAddress);
                hotelListNiceView.getHotelList().add(newHotel);
            }
            port.hotelListNiceView(sessionID, hotelListNiceView);
        } catch (Exception ex) {
            // handle custom exceptions
            System.out.println(ex.getMessage());
        }
    }

    public boolean bookHotel(java.lang.String bookingNum,
            ws.niceview.types.CreditCardInfoType creditCardInfo) {

        boolean status;
        // retrieve the hotel
        Hotel hotel = hotelDatabase.getHotel(bookingNum);

        if (hotel!=null && hotel.isHotelCreditGurantee()) {
            //call validateCreditCard of bankService
            try { 
                // Create the Web Service port
                dk.dtu.imm.fastmoney.BankService service =
                        new dk.dtu.imm.fastmoney.BankService();
                dk.dtu.imm.fastmoney.BankPortType port = service.getBankPort();

                // initialize WS operation arguments
                int group = 10;
                int amount = (int) hotel.getHotelPrice();

                dk.dtu.imm.fastmoney.types.ExpirationDateType cardDate =
                        new dk.dtu.imm.fastmoney.types.ExpirationDateType();
                cardDate.setMonth(creditCardInfo.getExpirationDate().getMonth());
                cardDate.setYear(creditCardInfo.getExpirationDate().getYear());

                dk.dtu.imm.fastmoney.types.CreditCardInfoType cardInfo =
                        new dk.dtu.imm.fastmoney.types.CreditCardInfoType();
                cardInfo.setExpirationDate(cardDate);
                cardInfo.setName(creditCardInfo.getName());
                cardInfo.setNumber(creditCardInfo.getNumber());
                
             // Call Web Service Operation
                status = port.validateCreditCard(group, cardInfo, amount);

            } catch (CreditCardFaultMessage fault) {
                System.out.println("Fault Message : " + fault.getFaultInfo().getMessage());
                return false;
            } catch (Exception ex) {
                System.out.println("Error Message : " + ex.getCause());
                return false;
            }
            return status;

        } else {
            return true;
        }
    }

    public boolean cancelHotel(java.lang.String bookingNum) {
        if (hotelDatabase.getHotel(bookingNum) == null) {
            return false;
        } else {
            return true;
        }
    }
}
