/*
 * 
 * 
 */

package WEBSERVICE;

import javax.jws.WebService;
import ws.helperservice.HelperServicePortType;

import java.util.UUID;
import java.util.HashMap;
import ws.travelgood.types.Itinerary;
import ws.travelgood.types.FlightInfo;

/**
 *
 * @author
 */
@WebService(serviceName = "HelperServiceService", 
    portName = "HelperServicePort",
    endpointInterface = "ws.helperservice.HelperServicePortType",
    targetNamespace = "urn://helperservice.ws",
    wsdlLocation = "WEB-INF/wsdl/HelperService/HelperService.wsdl")
public class HelperService implements HelperServicePortType {

    // creating a hashmap as the database to maintain
    // the mapping between itinerary & sessionID
    HashMap SessionDatabase = new HashMap();

    public ws.travelgood.types.Itinerary getItinerary(java.lang.String sessionID) {
        return (ws.travelgood.types.Itinerary) (SessionDatabase.get(sessionID));
    }

    public java.lang.String addFlightToItinerary(ws.travelgood.types.FlightInfo flightInfo, java.lang.String sessionID) {
        try {
            // retrieve the itinerary for the sessionID
            ws.travelgood.types.Itinerary itinerary =
                    (Itinerary) SessionDatabase.get(sessionID);
            // make a new Flight itinerary
            ws.travelgood.types.FlightItinerary flight =
                    new ws.travelgood.types.FlightItinerary();
            flight.setFlightInfo(flightInfo);
            flight.setConfirmation("unconfirmed");
            // add it to the list
            itinerary.getFlightList().add(flight);
        } catch (Exception e) {
            return "Exception occured while adding flight to itinerary.";
        }

        return "Flight added to itinerary successfully.";
    }

    public java.lang.String addHotelToItinerary(java.lang.String sessionID, ws.travelgood.types.Hotel hotel) {
        try {
            // retrieve the itinerary for the sessionID
            ws.travelgood.types.Itinerary itinerary =
                    (Itinerary) SessionDatabase.get(sessionID);
            // make a new Hotel itinerary
            ws.travelgood.types.HotelItinerary hotelIT =
                    new ws.travelgood.types.HotelItinerary();
            hotelIT.setHotelInfo(hotel);
            hotelIT.setConfirmation("unconfirmed");
            // add it to the list
            if(!hotelIT.getHotelInfo().getHotelReservationService().equalsIgnoreCase("none"))
                itinerary.getHotelList().add(hotelIT);
            else{
                System.out.println("This hotel doesn't exist");
                return "Cannot find hotel.";
            }

        } catch (Exception e) {
            return "Exception occured while adding flight to itinerary.";
        }

        return "Flight added to itinerary successfully.";
    }

    public ws.travelgood.types.FlightList mergeFlightList(ws.travelgood.types.FlightList list1, ws.travelgood.types.FlightList list2) {
        ws.travelgood.types.FlightList mergedList =
                new ws.travelgood.types.FlightList();
        for(FlightInfo flightInfo: list1.getFlightInfo()){
            if(!flightInfo.getReservationService().equalsIgnoreCase("none")){
                mergedList.getFlightInfo().add(flightInfo);
            }
        }
        for(FlightInfo flightInfo: list2.getFlightInfo()){
            if(!flightInfo.getReservationService().equalsIgnoreCase("none")){
                mergedList.getFlightInfo().add(flightInfo);
            }
        }

        return mergedList;
    }

    public java.lang.String startPlanning(java.lang.String input) {
        // creating an itinerary
        ws.travelgood.types.Itinerary itinerary =
                new ws.travelgood.types.Itinerary();
        // generateing the session id
        UUID id = UUID.randomUUID();
        String sessionID = id.toString();
        itinerary.setSessionID(sessionID);
        // adding in the database for future
        SessionDatabase.put(sessionID, itinerary);
        return sessionID;
    }

}
