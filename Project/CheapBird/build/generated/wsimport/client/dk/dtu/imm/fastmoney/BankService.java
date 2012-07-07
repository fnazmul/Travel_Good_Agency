
package dk.dtu.imm.fastmoney;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3.1-hudson-749-SNAPSHOT
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "BankService", targetNamespace = "urn://fastmoney.imm.dtu.dk", wsdlLocation = "http://fastmoney.imm.dtu.dk:8080/BankService?wsdl")
public class BankService
    extends Service
{

    private final static URL BANKSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(dk.dtu.imm.fastmoney.BankService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = dk.dtu.imm.fastmoney.BankService.class.getResource(".");
            url = new URL(baseUrl, "http://fastmoney.imm.dtu.dk:8080/BankService?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://fastmoney.imm.dtu.dk:8080/BankService?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        BANKSERVICE_WSDL_LOCATION = url;
    }

    public BankService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BankService() {
        super(BANKSERVICE_WSDL_LOCATION, new QName("urn://fastmoney.imm.dtu.dk", "BankService"));
    }

    /**
     * 
     * @return
     *     returns BankPortType
     */
    @WebEndpoint(name = "BankPort")
    public BankPortType getBankPort() {
        return super.getPort(new QName("urn://fastmoney.imm.dtu.dk", "BankPort"), BankPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BankPortType
     */
    @WebEndpoint(name = "BankPort")
    public BankPortType getBankPort(WebServiceFeature... features) {
        return super.getPort(new QName("urn://fastmoney.imm.dtu.dk", "BankPort"), BankPortType.class, features);
    }

}