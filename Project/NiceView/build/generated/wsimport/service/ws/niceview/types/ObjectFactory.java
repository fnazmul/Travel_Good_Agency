
package ws.niceview.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws.niceview.types package. 
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

    private final static QName _Hotel_QNAME = new QName("urn://types.niceview.ws", "Hotel");
    private final static QName _SearchHotel_QNAME = new QName("urn://types.niceview.ws", "SearchHotel");
    private final static QName _HotelAddress_QNAME = new QName("urn://types.niceview.ws", "HotelAddress");
    private final static QName _HotelList_QNAME = new QName("urn://types.niceview.ws", "HotelList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.niceview.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreditCardInfoType }
     * 
     */
    public CreditCardInfoType createCreditCardInfoType() {
        return new CreditCardInfoType();
    }

    /**
     * Create an instance of {@link HotelList }
     * 
     */
    public HotelList createHotelList() {
        return new HotelList();
    }

    /**
     * Create an instance of {@link HotelAddress }
     * 
     */
    public HotelAddress createHotelAddress() {
        return new HotelAddress();
    }

    /**
     * Create an instance of {@link Hotel }
     * 
     */
    public Hotel createHotel() {
        return new Hotel();
    }

    /**
     * Create an instance of {@link SearchHotel }
     * 
     */
    public SearchHotel createSearchHotel() {
        return new SearchHotel();
    }

    /**
     * Create an instance of {@link ExpirationDateType }
     * 
     */
    public ExpirationDateType createExpirationDateType() {
        return new ExpirationDateType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hotel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://types.niceview.ws", name = "Hotel")
    public JAXBElement<Hotel> createHotel(Hotel value) {
        return new JAXBElement<Hotel>(_Hotel_QNAME, Hotel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchHotel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://types.niceview.ws", name = "SearchHotel")
    public JAXBElement<SearchHotel> createSearchHotel(SearchHotel value) {
        return new JAXBElement<SearchHotel>(_SearchHotel_QNAME, SearchHotel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HotelAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://types.niceview.ws", name = "HotelAddress")
    public JAXBElement<HotelAddress> createHotelAddress(HotelAddress value) {
        return new JAXBElement<HotelAddress>(_HotelAddress_QNAME, HotelAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HotelList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn://types.niceview.ws", name = "HotelList")
    public JAXBElement<HotelList> createHotelList(HotelList value) {
        return new JAXBElement<HotelList>(_HotelList_QNAME, HotelList.class, null, value);
    }

}
