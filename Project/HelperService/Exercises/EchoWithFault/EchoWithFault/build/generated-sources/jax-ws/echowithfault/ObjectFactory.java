
package echowithfault;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the echowithfault package. 
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

    private final static QName _Output_QNAME = new QName("urn:echowithfault", "output");
    private final static QName _Input_QNAME = new QName("urn:echowithfault", "input");
    private final static QName _FaultElement_QNAME = new QName("urn:echowithfault", "faultElement");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: echowithfault
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:echowithfault", name = "output")
    public JAXBElement<String> createOutput(String value) {
        return new JAXBElement<String>(_Output_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:echowithfault", name = "input")
    public JAXBElement<String> createInput(String value) {
        return new JAXBElement<String>(_Input_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:echowithfault", name = "faultElement")
    public JAXBElement<String> createFaultElement(String value) {
        return new JAXBElement<String>(_FaultElement_QNAME, String.class, null, value);
    }

}
