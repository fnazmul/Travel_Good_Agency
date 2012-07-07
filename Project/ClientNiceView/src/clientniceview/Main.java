/*
 * 
 * 
 */

package clientniceview;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import ws.niceview.types.ExpirationDateType;

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

        try { // Call Web Service Operation
            ws.niceview.NiceViewService service = new ws.niceview.NiceViewService();
            ws.niceview.NiceViewPortType port = service.getNiceViewPort();
            // TODO initialize WS operation arguments here
            ws.niceview.types.SearchHotel searchInfo = new ws.niceview.types.SearchHotel();

            DatatypeFactory df = DatatypeFactory.newInstance();
            XMLGregorianCalendar value = df.newXMLGregorianCalendar(2010, 12, 14, 14, 0, 0, 0, 2);
            searchInfo.setArrivalDate(value);
            searchInfo.setCity("London");
            searchInfo.setDepartureDate(value);
            java.lang.String sessionID = "sessionID";
            port.getHotels(searchInfo, sessionID);

            // TODO initialize WS operation arguments here
            java.lang.String bookingNum = "Hotel1";
            ws.niceview.types.CreditCardInfoType creditCardInfo = new ws.niceview.types.CreditCardInfoType();
            creditCardInfo.setName("Tick Joachim");
            creditCardInfo.setNumber("50408824");
            ws.niceview.types.ExpirationDateType date = new ExpirationDateType();
            date.setMonth(2);
            date.setYear(11);
            creditCardInfo.setExpirationDate(date);
            // TODO process result here
            //boolean result = port.bookHotel(bookingNum, creditCardInfo);
            //System.out.println("Result of Book Hotel = "+result);

            // TODO process result here
            //result = port.cancelHotel(bookingNum);
            //System.out.println("Result of Cancel Hotel = "+result);

        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }            
        


    }

}
