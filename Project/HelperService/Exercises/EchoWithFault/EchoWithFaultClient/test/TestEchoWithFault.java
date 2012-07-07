
import echowithfault.EchoFault;
import echowithfault.EchoWithFaultPortType;
import echowithfault.EchoWithFaultService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestEchoWithFault {

    @Test
    public void testEchoWithFault() {
        EchoWithFaultService service = new EchoWithFaultService();
        EchoWithFaultPortType port = service.getEchoWithFaultPort();
        String part1 = "";
        String result;
        try {
            result = port.echo(part1);
            System.out.println("Result = " + result);
            fail();
        } catch (EchoFault ex) {
            assertEquals("My own defined fault element",ex.getFaultInfo());
        }

    }
}
