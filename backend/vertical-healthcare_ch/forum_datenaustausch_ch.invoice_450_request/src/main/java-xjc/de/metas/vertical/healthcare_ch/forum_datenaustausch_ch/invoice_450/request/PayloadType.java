//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.03.15 at 05:11:48 PM EET 
//


package de.metas.vertical.healthcare_ch.forum_datenaustausch_ch.invoice_450.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for payloadType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="payloadType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="credit" type="{http://www.forum-datenaustausch.ch/invoice}creditType" minOccurs="0"/&gt;
 *         &lt;element name="invoice" type="{http://www.forum-datenaustausch.ch/invoice}invoiceType"/&gt;
 *         &lt;element name="reminder" type="{http://www.forum-datenaustausch.ch/invoice}reminderType" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="body" type="{http://www.forum-datenaustausch.ch/invoice}bodyType"/&gt;
 *           &lt;element ref="{http://www.w3.org/2001/04/xmlenc#}EncryptedData"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="type" default="invoice"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *             &lt;enumeration value="invoice"/&gt;
 *             &lt;enumeration value="reminder"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="storno" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="copy" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="if_storno_followup_invoice_probable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "payloadType", namespace = "http://www.forum-datenaustausch.ch/invoice", propOrder = {
    "credit",
    "invoice",
    "reminder",
    "body",
    "encryptedData"
})
public class PayloadType {

    @XmlElement(namespace = "http://www.forum-datenaustausch.ch/invoice")
    protected CreditType credit;
    @XmlElement(namespace = "http://www.forum-datenaustausch.ch/invoice", required = true)
    protected InvoiceType invoice;
    @XmlElement(namespace = "http://www.forum-datenaustausch.ch/invoice")
    protected ReminderType reminder;
    @XmlElement(namespace = "http://www.forum-datenaustausch.ch/invoice")
    protected BodyType body;
    @XmlElement(name = "EncryptedData", namespace = "http://www.w3.org/2001/04/xmlenc#")
    protected EncryptedDataType encryptedData;
    @XmlAttribute(name = "type")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "storno")
    protected Boolean storno;
    @XmlAttribute(name = "copy")
    protected Boolean copy;
    @XmlAttribute(name = "if_storno_followup_invoice_probable")
    protected Boolean ifStornoFollowupInvoiceProbable;

    /**
     * Gets the value of the credit property.
     * 
     * @return
     *     possible object is
     *     {@link CreditType }
     *     
     */
    public CreditType getCredit() {
        return credit;
    }

    /**
     * Sets the value of the credit property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditType }
     *     
     */
    public void setCredit(CreditType value) {
        this.credit = value;
    }

    /**
     * Gets the value of the invoice property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceType }
     *     
     */
    public InvoiceType getInvoice() {
        return invoice;
    }

    /**
     * Sets the value of the invoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceType }
     *     
     */
    public void setInvoice(InvoiceType value) {
        this.invoice = value;
    }

    /**
     * Gets the value of the reminder property.
     * 
     * @return
     *     possible object is
     *     {@link ReminderType }
     *     
     */
    public ReminderType getReminder() {
        return reminder;
    }

    /**
     * Sets the value of the reminder property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReminderType }
     *     
     */
    public void setReminder(ReminderType value) {
        this.reminder = value;
    }

    /**
     * Gets the value of the body property.
     * 
     * @return
     *     possible object is
     *     {@link BodyType }
     *     
     */
    public BodyType getBody() {
        return body;
    }

    /**
     * Sets the value of the body property.
     * 
     * @param value
     *     allowed object is
     *     {@link BodyType }
     *     
     */
    public void setBody(BodyType value) {
        this.body = value;
    }

    /**
     * Gets the value of the encryptedData property.
     * 
     * @return
     *     possible object is
     *     {@link EncryptedDataType }
     *     
     */
    public EncryptedDataType getEncryptedData() {
        return encryptedData;
    }

    /**
     * Sets the value of the encryptedData property.
     * 
     * @param value
     *     allowed object is
     *     {@link EncryptedDataType }
     *     
     */
    public void setEncryptedData(EncryptedDataType value) {
        this.encryptedData = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        if (type == null) {
            return "invoice";
        } else {
            return type;
        }
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the storno property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isStorno() {
        if (storno == null) {
            return false;
        } else {
            return storno;
        }
    }

    /**
     * Sets the value of the storno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStorno(Boolean value) {
        this.storno = value;
    }

    /**
     * Gets the value of the copy property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isCopy() {
        if (copy == null) {
            return false;
        } else {
            return copy;
        }
    }

    /**
     * Sets the value of the copy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCopy(Boolean value) {
        this.copy = value;
    }

    /**
     * Gets the value of the ifStornoFollowupInvoiceProbable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIfStornoFollowupInvoiceProbable() {
        if (ifStornoFollowupInvoiceProbable == null) {
            return true;
        } else {
            return ifStornoFollowupInvoiceProbable;
        }
    }

    /**
     * Sets the value of the ifStornoFollowupInvoiceProbable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIfStornoFollowupInvoiceProbable(Boolean value) {
        this.ifStornoFollowupInvoiceProbable = value;
    }

}
