/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clienthelperservice;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import ws.travelgood.types.Hotel;
import ws.travelgood.types.HotelAddress;

/**
 *
 * @author FarihaMuna
 */
public class Main {

    /**
     * @param args the command line arguments
     */



    public static void main(String[] args) {

        // check start planning
        try { // Call Web Service Operation
            ws.helperservice.HelperServiceService service = new ws.helperservice.HelperServiceService();
            ws.helperservice.HelperServicePortType port = service.getHelperServicePort();
            // initialize WS operation arguments
            java.lang.String inout = "test";
            // process result
            java.lang.String sessionID = port.startPlanning(inout);
            System.out.println("Testing startPlanning...");
            System.out.println("SessionID = " + sessionID);

            //check add flight1 to itinerary
            ws.travelgood.types.Flight flight1 = new ws.travelgood.types.Flight();
            flight1.setTo("London");
            flight1.setFrom("Copenhagen");
            flight1.setCarrier("SAS");
            DatatypeFactory df = DatatypeFactory.newInstance();
            XMLGregorianCalendar value = df.newXMLGregorianCalendar("2010-11-17");
            flight1.setArrivalDate(value);
            flight1.setDepartureDate(value);

            ws.travelgood.types.FlightInfo flightInfo = new ws.travelgood.types.FlightInfo();
            flightInfo.setBookingNo("xuysdsfsdfds");
            flightInfo.setPrice(450);
            flightInfo.setReservationService("CheapBird");
            flightInfo.setFlight(flight1);

            String result = port.addFlightToItinerary(flightInfo, sessionID);
            System.out.println("Result of addFlightToItinerary= " + result);

            //check addhotel to itinerary
            ws.travelgood.types.Hotel hotel = new Hotel();
            ws.travelgood.types.HotelAddress address = new HotelAddress();
            address.setCity("London");
            address.setStreet("London Avenue");
            hotel.setHotelAddress(address);
            hotel.setHotelBookingNo("hotel1");
            hotel.setHotelCreditGurantee(true);
            hotel.setHotelName("London Hotel");
            hotel.setHotelPrice(200);
            hotel.setHotelReservationService("NiceView");

            result = port.addHotelToItinerary(sessionID, hotel);
            System.out.println("Result of addHotelToItinerary= " + result);

            //check getItinerary
            ws.travelgood.types.Itinerary it = port.getItinerary(sessionID);
            System.out.println("Testing getItinerary");
            System.out.println("FlightItinerary = " + it.getFlightList().get(0).getFlightInfo().getReservationService());
            System.out.println("HotelItinerary = " + it.getHotelList().get(0).getHotelInfo().getHotelReservationService());

            // check merge flight1
            // create flight1 list 2
            ws.travelgood.types.Flight flight2 = new ws.travelgood.types.Flight();
            flight2.setTo("PARIS");
            flight2.setFrom("BERLIN");
            flight2.setCarrier("KLM");
            DatatypeFactory d2 = DatatypeFactory.newInstance();
            XMLGregorianCalendar value2 = d2.newXMLGregorianCalendar("2009-11-17");
            flight2.setArrivalDate(value2);
            flight2.setDepartureDate(value2);

            ws.travelgood.types.FlightInfo flightInfo2 = new ws.travelgood.types.FlightInfo();
            flightInfo2.setBookingNo("secondbookingno");
            flightInfo2.setPrice(450);
            flightInfo2.setReservationService("LameDuck");
            flightInfo2.setFlight(flight2);

            ws.travelgood.types.FlightList list1 = new ws.travelgood.types.FlightList();
            list1.getFlightInfo().add(flightInfo);

            ws.travelgood.types.FlightList list2 = new ws.travelgood.types.FlightList();
            list2.getFlightInfo().add(flightInfo2);
            // TODO process result here
            ws.travelgood.types.FlightList flightList = port.mergeFlightList(list1, list2);
            System.out.println("Flight1 Carrier = " + flightList.getFlightInfo().get(0).getFlight().getCarrier().toString());
            System.out.println("Flight2 Carrier = " + flightList.getFlightInfo().get(1).getFlight().getCarrier().toString());
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            //System.out.println(ex.getCause());
        }




    }
}
