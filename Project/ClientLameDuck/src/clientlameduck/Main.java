/*
 * 
 * 
 */
package clientlameduck;

/**
 *
 * @author 
 */
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import ws.airlinereservation.types.ExpirationDateType;

/**
 *
 * @author
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            // Call Web Service Operation
            ws.lameduck.LameDuckService service = new ws.lameduck.LameDuckService();
            ws.lameduck.LameDuckPortType port = service.getLameDuckPort();
            // initialize WS operation arguments here
            ws.airlinereservation.types.SearchFlight searchFlight =
                    new ws.airlinereservation.types.SearchFlight();
            java.lang.String sessionID = "sessionID";

            GregorianCalendar gc = new GregorianCalendar();
            Date date = new Date();
            gc.setTimeInMillis(date.getTime());
            DatatypeFactory df;
            javax.xml.datatype.XMLGregorianCalendar value = null;
            try {
                df = DatatypeFactory.newInstance();
                value = df.newXMLGregorianCalendar(gc);
            } catch (DatatypeConfigurationException ex) {
                System.out.println(ex.getMessage());
            }

            searchFlight.setDepartureDate(value);
            searchFlight.setFrom("Barcelona");
            searchFlight.setTo("Berlin");

            port.getFlights(searchFlight, sessionID);


            java.lang.String bookingNo = "Flight-910";
            ws.airlinereservation.types.CreditCardInfoType creditCardInfo =
                    new ws.airlinereservation.types.CreditCardInfoType();
            ws.airlinereservation.types.ExpirationDateType carddate =
                    new ExpirationDateType();
            carddate.setMonth(2);
            carddate.setYear(11);
            creditCardInfo.setName("Tick Joachim");
            creditCardInfo.setNumber("50408824");
            creditCardInfo.setExpirationDate(carddate);

            boolean result = port.bookFlight(bookingNo, creditCardInfo);
            System.out.println("Result of bookFlight = " + result);

            result = port.cancelFlight(bookingNo, creditCardInfo);
            System.out.println("Result of cancelFlight = " + result);

        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }


    }
}
