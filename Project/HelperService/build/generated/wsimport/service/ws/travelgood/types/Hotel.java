
package ws.travelgood.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Hotel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Hotel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="HotelAddress" type="{urn://types.travelgood.ws}HotelAddress"/>
 *         &lt;element name="HotelBookingNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="HotelPrice" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="HotelCreditGurantee" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="HotelReservationService" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Hotel", propOrder = {
    "hotelName",
    "hotelAddress",
    "hotelBookingNo",
    "hotelPrice",
    "hotelCreditGurantee",
    "hotelReservationService"
})
public class Hotel {

    @XmlElement(name = "HotelName", required = true)
    protected String hotelName;
    @XmlElement(name = "HotelAddress", required = true)
    protected HotelAddress hotelAddress;
    @XmlElement(name = "HotelBookingNo", required = true)
    protected String hotelBookingNo;
    @XmlElement(name = "HotelPrice")
    protected float hotelPrice;
    @XmlElement(name = "HotelCreditGurantee")
    protected boolean hotelCreditGurantee;
    @XmlElement(name = "HotelReservationService", required = true)
    protected String hotelReservationService;

    /**
     * Gets the value of the hotelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Sets the value of the hotelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelName(String value) {
        this.hotelName = value;
    }

    /**
     * Gets the value of the hotelAddress property.
     * 
     * @return
     *     possible object is
     *     {@link HotelAddress }
     *     
     */
    public HotelAddress getHotelAddress() {
        return hotelAddress;
    }

    /**
     * Sets the value of the hotelAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelAddress }
     *     
     */
    public void setHotelAddress(HotelAddress value) {
        this.hotelAddress = value;
    }

    /**
     * Gets the value of the hotelBookingNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelBookingNo() {
        return hotelBookingNo;
    }

    /**
     * Sets the value of the hotelBookingNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelBookingNo(String value) {
        this.hotelBookingNo = value;
    }

    /**
     * Gets the value of the hotelPrice property.
     * 
     */
    public float getHotelPrice() {
        return hotelPrice;
    }

    /**
     * Sets the value of the hotelPrice property.
     * 
     */
    public void setHotelPrice(float value) {
        this.hotelPrice = value;
    }

    /**
     * Gets the value of the hotelCreditGurantee property.
     * 
     */
    public boolean isHotelCreditGurantee() {
        return hotelCreditGurantee;
    }

    /**
     * Sets the value of the hotelCreditGurantee property.
     * 
     */
    public void setHotelCreditGurantee(boolean value) {
        this.hotelCreditGurantee = value;
    }

    /**
     * Gets the value of the hotelReservationService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelReservationService() {
        return hotelReservationService;
    }

    /**
     * Sets the value of the hotelReservationService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelReservationService(String value) {
        this.hotelReservationService = value;
    }

}
