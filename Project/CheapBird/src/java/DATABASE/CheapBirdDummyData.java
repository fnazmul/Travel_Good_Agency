/*
 * 
 * 
 */
package DATABASE;

import java.util.ArrayList;
//import java.util.Date;
//import java.util.GregorianCalendar;
import java.util.Random;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import ws.airlinereservation.types.Flight;
import ws.airlinereservation.types.FlightInfo;
import ws.airlinereservation.types.FlightList;
import ws.airlinereservation.types.SearchFlight;

/**
 *
 * @author
 */
public class CheapBirdDummyData {

    private ArrayList<FlightInfo> flightDatabase = new ArrayList<FlightInfo>();
    private ArrayList<String> places;

    public CheapBirdDummyData() {
        FlightInfo flightInfo = new FlightInfo();
        Flight flight = new Flight();
        places = new ArrayList<String>();

        places.add("Amsterdam");
        places.add("Copenhagen");
        places.add("Bonn");
        places.add("London");
        places.add("Oslo");
        places.add("Stockholm");
        places.add("Brussels");
        places.add("Paris");
        places.add("Berlin");
        places.add("Helsinki");
        places.add("Barcelona");


        if (flightDatabase.isEmpty()) {
            for (int i = 0; i < places.size() - 1; i++) {
                for (int j = i + 1; j < places.size(); j++) {
                    try {
                        Random rand = new Random();
                        flightInfo.setBookingNo("Flight-" + rand.nextInt(100));
                        flightInfo.setPrice(rand.nextInt(500));
                        flightInfo.setReservationService("CheapBird");
                        // TODO code application logic here
                        DatatypeFactory df = DatatypeFactory.newInstance();
                        XMLGregorianCalendar date = df.newXMLGregorianCalendar();
                        date.setYear(2010);
                        date.setMonth(12);
                        date.setDay(20);
                        date.setTime(7+i, 30, 0);
                        flight.setArrivalDate(date);
                        date.setTime(7+i+2, 30, 0);
                        flight.setDepartureDate(date);
                        flight.setCarrier("SAS");
                        flight.setFrom(places.get(i));
                        flight.setTo(places.get(j));
                        flightInfo.setFlight(flight);
                        flightDatabase.add(flightInfo);
                    } catch (DatatypeConfigurationException ex) {
                        System.out.println("Date type wrong");
                    }
                }
            }
        }
    }

    public FlightList getFlightList(SearchFlight searchFlight) {

        String from = searchFlight.getFrom().trim();
        String to = searchFlight.getTo().trim();
        javax.xml.datatype.XMLGregorianCalendar date = searchFlight.getDepartureDate();

        FlightList findList = new FlightList();

        for (FlightInfo flight : this.flightDatabase) {
            if (flight.getFlight().getFrom().equalsIgnoreCase(from) &&
                    flight.getFlight().getTo().equalsIgnoreCase(to) &&
                    (flight.getFlight().getDepartureDate().equals(date))) {

                findList.getFlightInfo().add(flight);
            }
        }
        return findList;
    }

    public FlightInfo getFlight(String bookingNo) {
        FlightInfo tempFlight = null;
        if (flightDatabase.contains(bookingNo)) {
            tempFlight = flightDatabase.get(flightDatabase.indexOf(bookingNo));
        }
        return tempFlight;
    }

    public int getPrice(String bookingNo) {
        for (FlightInfo flightInfo : this.flightDatabase) {
            if (flightInfo.getBookingNo().equals(bookingNo)) {
                return (int) flightInfo.getPrice();
            }
        }
        return 0;
    }
}
