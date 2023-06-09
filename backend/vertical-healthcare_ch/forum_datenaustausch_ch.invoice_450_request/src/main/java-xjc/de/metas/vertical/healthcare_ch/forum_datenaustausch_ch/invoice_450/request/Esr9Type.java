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
 * <p>Java class for esr9Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="esr9Type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bank" type="{http://www.forum-datenaustausch.ch/invoice}esrAddressType" minOccurs="0"/&gt;
 *         &lt;element name="creditor" type="{http://www.forum-datenaustausch.ch/invoice}esrAddressType"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="type" default="16or27"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *             &lt;enumeration value="16or27plus"/&gt;
 *             &lt;enumeration value="16or27"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="participant_number" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;pattern value="01-[1-9][0-9]{0,5}-[0-9]"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="reference_number" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;pattern value="([0-9] [0-9]{5} [0-9]{5} [0-9]{5}|[0-9]{2} [0-9]{5} [0-9]{5} [0-9]{5} [0-9]{5} [0-9]{5})"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="coding_line" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;pattern value="(01[0-9]{11}&gt;[0-9]{16}\+ [0-9]{9}&gt;|042&gt;[0-9]{16}\+ [0-9]{9}&gt;|01[0-9]{11}&gt;[0-9]{27}\+ [0-9]{9}&gt;|042&gt;[0-9]{27}\+ [0-9]{9}&gt;)"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "esr9Type", namespace = "http://www.forum-datenaustausch.ch/invoice", propOrder = {
    "bank",
    "creditor"
})
public class Esr9Type {

    @XmlElement(namespace = "http://www.forum-datenaustausch.ch/invoice")
    protected EsrAddressType bank;
    @XmlElement(namespace = "http://www.forum-datenaustausch.ch/invoice", required = true)
    protected EsrAddressType creditor;
    @XmlAttribute(name = "type")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "participant_number", required = true)
    protected String participantNumber;
    @XmlAttribute(name = "reference_number", required = true)
    protected String referenceNumber;
    @XmlAttribute(name = "coding_line", required = true)
    protected String codingLine;

    /**
     * Gets the value of the bank property.
     * 
     * @return
     *     possible object is
     *     {@link EsrAddressType }
     *     
     */
    public EsrAddressType getBank() {
        return bank;
    }

    /**
     * Sets the value of the bank property.
     * 
     * @param value
     *     allowed object is
     *     {@link EsrAddressType }
     *     
     */
    public void setBank(EsrAddressType value) {
        this.bank = value;
    }

    /**
     * Gets the value of the creditor property.
     * 
     * @return
     *     possible object is
     *     {@link EsrAddressType }
     *     
     */
    public EsrAddressType getCreditor() {
        return creditor;
    }

    /**
     * Sets the value of the creditor property.
     * 
     * @param value
     *     allowed object is
     *     {@link EsrAddressType }
     *     
     */
    public void setCreditor(EsrAddressType value) {
        this.creditor = value;
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
            return "16or27";
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
     * Gets the value of the participantNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParticipantNumber() {
        return participantNumber;
    }

    /**
     * Sets the value of the participantNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParticipantNumber(String value) {
        this.participantNumber = value;
    }

    /**
     * Gets the value of the referenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * Sets the value of the referenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceNumber(String value) {
        this.referenceNumber = value;
    }

    /**
     * Gets the value of the codingLine property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodingLine() {
        return codingLine;
    }

    /**
     * Sets the value of the codingLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodingLine(String value) {
        this.codingLine = value;
    }

}
