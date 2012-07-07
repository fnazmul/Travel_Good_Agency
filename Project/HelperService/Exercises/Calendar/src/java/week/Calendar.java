/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package week;

import java.util.HashMap;
import javax.jws.WebService;
import ws.exercise03.CalendarWSDLPortType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author FarihaMuna
 */
@WebService(serviceName = "CalendarWSDLService", portName = "CalendarWSDLPort", endpointInterface = "ws.exercise03.CalendarWSDLPortType", targetNamespace = "urn://exercise03.ws", wsdlLocation = "WEB-INF/wsdl/Calendar/CalendarWSDL.wsdl")
public class Calendar implements CalendarWSDLPortType {

    public HashMap<XMLGregorianCalendar, String> Appointments =  new HashMap<XMLGregorianCalendar, String>();

    public void addApp(javax.xml.datatype.XMLGregorianCalendar part1, java.lang.String part2) {
        //TODO implement this method
        Appointments.put(part1, part2);
    }

    public java.lang.String getApp(javax.xml.datatype.XMLGregorianCalendar part1) {
        //TODO implement this method
        return (String)(Appointments.get(part1));
    }

}
