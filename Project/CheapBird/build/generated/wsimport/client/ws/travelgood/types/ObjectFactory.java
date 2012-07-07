
package ws.travelgood.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws.travelgood.types package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Flight_QNAME = new QName("urn://types.travelgood.ws", "Flight");
    private final static QName _FlightInfo_QNAME = new QName("urn://types.travelgood.ws", "FlightInfo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.travelgood.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Hotel }
     * 
     */
    public Hotel createHotel() {
        return new Hotel();
    }

    /**
     * Create an instance of {@link FlightList }
     * 
     */
    public FlightList createFlightList() {
        return new FlightList();
    }

    /**
     * Create an instance of {@link Flight }
     * 
     */
    public Flight createFlight() {
        return new Flight();
    }

    /**
     * Create an instance of {@link FlightItinerary }
     * 
     */
    public FlightItinerary createFlightItinerary() {
        return new FlightItinerary();
    }

    /**
     * Create an instance of {@link FlightInfo }
     * 
     */
    public FlightInfo createFlightInfo() {
        return new FlightInfo();
    }

    /**
     * Create an instance of {@link SearchFlight }
     * 
     */
    public SearchFlight createSearchFlight() {
        return new SearchFlight();
    }

    /**
     * Create an instance of {@link HotelItinerary }
     * 
     */
    public HotelItinerary createHotelItinerary() {
        return new HotelItinerary();
    }

    /**
     * Create an instance of {@link HotelList }
     * 
     */
    public HotelList createHotelList() {
        return new HotelList();
    }

    /**
     * Create an instance of {@link Itinerary }
     * 
     */
    public Itinerary createItinerary() {
        return new Itinerary();
    }

    /**
     * Create an instance of {@link HotelAddress }
     * 
     */
    public HotelAddress createHotelAddress() {
        return new HotelAddress();
    }

    /**
     * Create an instance of {@link SearchHotel }
     * 
     */
    public SearchHotel createSearchHotel() {
        return new SearchHotel();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Flight }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://types.travelgood.ws", name = "Flight")
    public JAXBElement<Flight> createFlight(Flight value) {
        return new JAXBElement<Flight>(_Flight_QNAME, Flight.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FlightInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://types.travelgood.ws", name = "FlightInfo")
    public JAXBElement<FlightInfo> createFlightInfo(FlightInfo value) {
        return new JAXBElement<FlightInfo>(_FlightInfo_QNAME, FlightInfo.class, null, value);
    }

}
