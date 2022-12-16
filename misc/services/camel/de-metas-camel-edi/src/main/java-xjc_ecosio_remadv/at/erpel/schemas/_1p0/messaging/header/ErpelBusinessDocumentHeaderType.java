//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.12 at 05:52:48 PM EET 
//


package at.erpel.schemas._1p0.messaging.header;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ErpelBusinessDocumentHeaderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ErpelBusinessDocumentHeaderType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/messaging/header}Sender" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/messaging/header}Receiver" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/messaging/header}MessageReceivedAt" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/messaging/header}SignatureVerification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/messaging/header}InterchangeHeader"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://erpel.at/schemas/1p0/messaging/header}ID"/&gt;
 *       &lt;attribute ref="{http://erpel.at/schemas/1p0/messaging/header}References"/&gt;
 *       &lt;attribute ref="{http://erpel.at/schemas/1p0/messaging/header}TestIndicator"/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ErpelBusinessDocumentHeaderType", propOrder = {
    "sender",
    "receiver",
    "messageReceivedAt",
    "signatureVerification",
    "interchangeHeader"
})
public class ErpelBusinessDocumentHeaderType {

    @XmlElement(name = "Sender")
    protected String sender;
    @XmlElement(name = "Receiver")
    protected String receiver;
    @XmlElement(name = "MessageReceivedAt")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar messageReceivedAt;
    @XmlElement(name = "SignatureVerification")
    protected SignatureVerificationType signatureVerification;
    @XmlElement(name = "InterchangeHeader", required = true)
    protected InterchangeHeaderType interchangeHeader;
    @XmlAttribute(name = "ID", namespace = "http://erpel.at/schemas/1p0/messaging/header")
    protected String id;
    @XmlAttribute(name = "References", namespace = "http://erpel.at/schemas/1p0/messaging/header")
    protected String references;
    @XmlAttribute(name = "TestIndicator", namespace = "http://erpel.at/schemas/1p0/messaging/header")
    protected Boolean testIndicator;

    /**
     * Deprecated. Please use InterchangeHeader/Sender/id. 
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSender() {
        return sender;
    }

    /**
     * Sets the value of the sender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSender(String value) {
        this.sender = value;
    }

    /**
     * Deprecated. Please use InterchangeHeader/Receiver/id. 
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * Sets the value of the receiver property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiver(String value) {
        this.receiver = value;
    }

    /**
     * Contains the date and time when the message was received at a specific location.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMessageReceivedAt() {
        return messageReceivedAt;
    }

    /**
     * Sets the value of the messageReceivedAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMessageReceivedAt(XMLGregorianCalendar value) {
        this.messageReceivedAt = value;
    }

    /**
     * Contains details about the digital signature, which may be applied to an ERPEL message. Deprecated.
     * 
     * @return
     *     possible object is
     *     {@link SignatureVerificationType }
     *     
     */
    public SignatureVerificationType getSignatureVerification() {
        return signatureVerification;
    }

    /**
     * Sets the value of the signatureVerification property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureVerificationType }
     *     
     */
    public void setSignatureVerification(SignatureVerificationType value) {
        this.signatureVerification = value;
    }

    /**
     * Contains all routing information. May include EDIFACT-specific data.
     * 
     * @return
     *     possible object is
     *     {@link InterchangeHeaderType }
     *     
     */
    public InterchangeHeaderType getInterchangeHeader() {
        return interchangeHeader;
    }

    /**
     * Sets the value of the interchangeHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterchangeHeaderType }
     *     
     */
    public void setInterchangeHeader(InterchangeHeaderType value) {
        this.interchangeHeader = value;
    }

    /**
     * The ID represents the unique number of the message.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * This segment contains references related to the message.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferences() {
        return references;
    }

    /**
     * Sets the value of the references property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferences(String value) {
        this.references = value;
    }

    /**
     * Flag indicating whether the message is a test message or not.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTestIndicator() {
        return testIndicator;
    }

    /**
     * Sets the value of the testIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTestIndicator(Boolean value) {
        this.testIndicator = value;
    }

}
