
package dk.dtu.imm.fastmoney;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import dk.dtu.imm.fastmoney.types.AccountType;
import dk.dtu.imm.fastmoney.types.CreditCardInfoType;
import dk.dtu.imm.fastmoney.types.ObjectFactory;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3.1-hudson-749-SNAPSHOT
 * Generated source version: 2.1
 * 
 */
@WebService(name = "BankPortType", targetNamespace = "urn://fastmoney.imm.dtu.dk")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BankPortType {


    /**
     * 
     * @param amount
     * @param account
     * @param group
     * @param creditCardInfo
     * @return
     *     returns boolean
     * @throws CreditCardFaultMessage
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "chargeCreditCard", targetNamespace = "urn://types.fastmoney.imm.dtu.dk", className = "dk.dtu.imm.fastmoney.types.ChargeCreditCard")
    @ResponseWrapper(localName = "chargeCreditCardResponse", targetNamespace = "urn://types.fastmoney.imm.dtu.dk", className = "dk.dtu.imm.fastmoney.types.ChargeCreditCardResponse")
    public boolean chargeCreditCard(
        @WebParam(name = "group", targetNamespace = "")
        int group,
        @WebParam(name = "creditCardInfo", targetNamespace = "")
        CreditCardInfoType creditCardInfo,
        @WebParam(name = "amount", targetNamespace = "")
        int amount,
        @WebParam(name = "account", targetNamespace = "")
        AccountType account)
        throws CreditCardFaultMessage
    ;

    /**
     * 
     * @param amount
     * @param group
     * @param creditCardInfo
     * @return
     *     returns boolean
     * @throws CreditCardFaultMessage
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "validateCreditCard", targetNamespace = "urn://types.fastmoney.imm.dtu.dk", className = "dk.dtu.imm.fastmoney.types.ValidateCreditCard")
    @ResponseWrapper(localName = "validateCreditCardResponse", targetNamespace = "urn://types.fastmoney.imm.dtu.dk", className = "dk.dtu.imm.fastmoney.types.ValidateCreditCardResponse")
    public boolean validateCreditCard(
        @WebParam(name = "group", targetNamespace = "")
        int group,
        @WebParam(name = "creditCardInfo", targetNamespace = "")
        CreditCardInfoType creditCardInfo,
        @WebParam(name = "amount", targetNamespace = "")
        int amount)
        throws CreditCardFaultMessage
    ;

    /**
     * 
     * @param amount
     * @param account
     * @param group
     * @param creditCardInfo
     * @return
     *     returns boolean
     * @throws CreditCardFaultMessage
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "refundCreditCard", targetNamespace = "urn://types.fastmoney.imm.dtu.dk", className = "dk.dtu.imm.fastmoney.types.RefundCreditCard")
    @ResponseWrapper(localName = "refundCreditCardResponse", targetNamespace = "urn://types.fastmoney.imm.dtu.dk", className = "dk.dtu.imm.fastmoney.types.RefundCreditCardResponse")
    public boolean refundCreditCard(
        @WebParam(name = "group", targetNamespace = "")
        int group,
        @WebParam(name = "creditCardInfo", targetNamespace = "")
        CreditCardInfoType creditCardInfo,
        @WebParam(name = "amount", targetNamespace = "")
        int amount,
        @WebParam(name = "account", targetNamespace = "")
        AccountType account)
        throws CreditCardFaultMessage
    ;

}
