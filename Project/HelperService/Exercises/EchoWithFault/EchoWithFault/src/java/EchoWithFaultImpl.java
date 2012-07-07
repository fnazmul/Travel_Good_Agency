/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import echowithfault.EchoFault;
import javax.jws.WebService;

/**
 *
 * @author hub
 */
@WebService(serviceName = "echoWithFaultService", portName = "echoWithFaultPort", endpointInterface = "echowithfault.EchoWithFaultPortType", targetNamespace = "urn:echowithfault", wsdlLocation = "WEB-INF/wsdl/EchoWithFaultImpl/echoWithFault.wsdl")
public class EchoWithFaultImpl {

    public java.lang.String echo(java.lang.String part1) throws echowithfault.EchoFault {
        //TODO implement this method
        throw new EchoFault("General Error message", "My own defined fault element");
    }

}
