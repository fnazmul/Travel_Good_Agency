/*
 * 
 * 
 */
package DATABASE;

import java.util.Date;
import java.util.Random;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeFactory;
import ws.airlinereservation.types.Flight;
import ws.airlinereservation.types.FlightInfo;
import ws.airlinereservation.types.FlightList;
import dk.dtu.imm.fastmoney.types.AccountType;
import ws.airlinereservation.types.SearchFlight;
import javax.xml.datatype.DatatypeConfigurationException;

/**
 *
 * @author
 */
public class LameDuckDummyData {

    private ArrayList<FlightInfo> flightDatabase = new ArrayList<FlightInfo>();
    private ArrayList<String> places;
    private AccountType account;

    public LameDuckDummyData() {
        FlightInfo flightInfo = new FlightInfo();
        Flight flight = new Flight();
        places = new ArrayList<String>();

        places.add("London");
        places.add("Copenhagen");
        places.add("Brussels");
        places.add("Paris");
        places.add("Amsterdam");
        places.add("Bonn");
        places.add("Helsinki");
        places.add("Oslo");
        places.add("Stockholm");
        places.add("Barcelona");
        places.add("Berlin");

        if (flightDatabase.isEmpty()) {
            for (int i = 0; i < places.size()-1; i++) {
                for (int j = i + 1; j < places.size(); j++) {
                    Random rand = new Random();
                    flightInfo.setBookingNo("Flight-" +i+j);//+ rand.nextInt(100));
                    flightInfo.setPrice(rand.nextInt(500));
                    flightInfo.setReservationService("LameDuck");
                    Date date = new Date();
                    flight.setArrivalDate(asXMLGregorianCalendar(date));
                    flight.setDepartureDate(asXMLGregorianCalendar(date));
                    flight.setCarrier("KLM");
                    flight.setFrom(places.get(i));
                    flight.setTo(places.get(j));
                    flightInfo.setFlight(flight);
                    flightDatabase.add(flightInfo);
                }
            }
        }
    }
    
    public FlightList getFlightList(SearchFlight searchFlight) {

        String from = searchFlight.getFrom().trim();
        String to = searchFlight.getTo().trim();
        javax.xml.datatype.XMLGregorianCalendar date =
                searchFlight.getDepartureDate();

        FlightList findList = new FlightList();

        for (FlightInfo flight : this.flightDatabase) {
            if (flight.getFlight().getFrom().equalsIgnoreCase(from) &&
                    flight.getFlight().getTo().equalsIgnoreCase(to) &&
                    (flight.getFlight().getDepartureDate().getDay()==(date.getDay())&&
                    flight.getFlight().getDepartureDate().getMonth()==(date.getMonth())&&
                    flight.getFlight().getDepartureDate().getYear()==(date.getYear()))){

                findList.getFlightInfo().add(flight);
            }
        }
        return findList;
    }

    public FlightInfo getFlight(String bookingNo) {
        FlightInfo tempFlight = null;
        for(FlightInfo flightInfo: flightDatabase){
            if(flightInfo.getBookingNo().equalsIgnoreCase(bookingNo))
                tempFlight = flightInfo;
        }
        //if (flightDatabase.contains(bookingNo)) {
        //    tempFlight = flightDatabase.get(flightDatabase.indexOf(bookingNo));
        //}
        return tempFlight;
    }

    public int getPrice(String bookingNo) {
        for (FlightInfo flightInfo : this.flightDatabase) {
            if (flightInfo.getBookingNo().equalsIgnoreCase(bookingNo)) {
                return (int) flightInfo.getPrice();
            }
        }
        return 0;
    }


    public AccountType getAccount() {
        this.account = new AccountType();
        account.setName("LameDuck");
        account.setNumber("50208812");
        return this.account;
    }

    public javax.xml.datatype.XMLGregorianCalendar asXMLGregorianCalendar(java.util.Date date) {
        if (date == null) {
            return null;
        } else {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTimeInMillis(date.getTime());
            DatatypeFactory df;
            try {
                df = DatatypeFactory.newInstance();
                javax.xml.datatype.XMLGregorianCalendar value = df.newXMLGregorianCalendar(gc);
                return value;
            } catch (DatatypeConfigurationException ex) {
                System.out.println(ex.getMessage());
            }

            return null;
        }
    }
}
