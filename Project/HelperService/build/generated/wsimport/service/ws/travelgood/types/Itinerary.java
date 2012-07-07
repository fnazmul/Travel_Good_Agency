
package ws.travelgood.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Itinerary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Itinerary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FlightList" type="{urn://types.travelgood.ws}FlightItinerary" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="HotelList" type="{urn://types.travelgood.ws}HotelItinerary" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SessionID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Itinerary", propOrder = {
    "flightList",
    "hotelList",
    "sessionID"
})
public class Itinerary {

    @XmlElement(name = "FlightList")
    protected List<FlightItinerary> flightList;
    @XmlElement(name = "HotelList")
    protected List<HotelItinerary> hotelList;
    @XmlElement(name = "SessionID", required = true)
    protected String sessionID;

    /**
     * Gets the value of the flightList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the flightList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFlightList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FlightItinerary }
     * 
     * 
     */
    public List<FlightItinerary> getFlightList() {
        if (flightList == null) {
            flightList = new ArrayList<FlightItinerary>();
        }
        return this.flightList;
    }

    /**
     * Gets the value of the hotelList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hotelList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHotelList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HotelItinerary }
     * 
     * 
     */
    public List<HotelItinerary> getHotelList() {
        if (hotelList == null) {
            hotelList = new ArrayList<HotelItinerary>();
        }
        return this.hotelList;
    }

    /**
     * Gets the value of the sessionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionID() {
        return sessionID;
    }

    /**
     * Sets the value of the sessionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionID(String value) {
        this.sessionID = value;
    }

}
