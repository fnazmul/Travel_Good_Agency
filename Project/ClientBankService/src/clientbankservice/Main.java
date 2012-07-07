package clientbankservice;

import dk.dtu.imm.fastmoney.CreditCardFaultMessage;
import dk.dtu.imm.fastmoney.types.ExpirationDateType;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // code application logic here

        try { // Call Web Service Operation
            dk.dtu.imm.fastmoney.BankService service = new dk.dtu.imm.fastmoney.BankService();
            dk.dtu.imm.fastmoney.BankPortType port = service.getBankPort();
            // initialize WS operation arguments here
            int group = 10;
            dk.dtu.imm.fastmoney.types.CreditCardInfoType creditCardInfo = new dk.dtu.imm.fastmoney.types.CreditCardInfoType();
            int amount = 100;

            creditCardInfo.setName("Tick Joachim");
            creditCardInfo.setNumber("50408824");
            dk.dtu.imm.fastmoney.types.ExpirationDateType value = new ExpirationDateType();
            value.setMonth(2);
            value.setYear(11);
            creditCardInfo.setExpirationDate(value);

            boolean result = port.validateCreditCard(group, creditCardInfo, amount);
            System.out.println("Result = " + result);
        } catch (CreditCardFaultMessage fault) {
            System.out.println(fault.getFaultInfo());
        } 


    }
}
