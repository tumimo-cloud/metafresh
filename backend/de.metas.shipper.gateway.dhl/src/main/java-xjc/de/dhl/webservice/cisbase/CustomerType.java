//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.09 at 05:46:45 PM CET 
//


package de.dhl.webservice.cisbase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Type of customer
 * 
 * <p>Java class for CustomerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Name" type="{http://dhl.de/webservice/cisbase}NameType"/&gt;
 *         &lt;element name="vatID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element ref="{http://dhl.de/webservice/cisbase}EKP"/&gt;
 *         &lt;element name="Address" type="{http://dhl.de/webservice/cisbase}NativeAddressType"/&gt;
 *         &lt;element name="Contact" type="{http://dhl.de/webservice/cisbase}ContactType"/&gt;
 *         &lt;element name="Bank" type="{http://dhl.de/webservice/cisbase}BankType" minOccurs="0"/&gt;
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerType", propOrder = {
    "name",
    "vatID",
    "ekp",
    "address",
    "contact",
    "bank",
    "note"
})
public class CustomerType {

    @XmlElement(name = "Name", required = true)
    protected NameType name;
    protected String vatID;
    @XmlElement(name = "EKP", required = true)
    protected String ekp;
    @XmlElement(name = "Address", required = true)
    protected NativeAddressType address;
    @XmlElement(name = "Contact", required = true)
    protected ContactType contact;
    @XmlElement(name = "Bank")
    protected BankType bank;
    protected Object note;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link NameType }
     *     
     */
    public NameType getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameType }
     *     
     */
    public void setName(NameType value) {
        this.name = value;
    }

    /**
     * Gets the value of the vatID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVatID() {
        return vatID;
    }

    /**
     * Sets the value of the vatID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVatID(String value) {
        this.vatID = value;
    }

    /**
     * Gets the value of the ekp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEKP() {
        return ekp;
    }

    /**
     * Sets the value of the ekp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEKP(String value) {
        this.ekp = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link NativeAddressType }
     *     
     */
    public NativeAddressType getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link NativeAddressType }
     *     
     */
    public void setAddress(NativeAddressType value) {
        this.address = value;
    }

    /**
     * Gets the value of the contact property.
     * 
     * @return
     *     possible object is
     *     {@link ContactType }
     *     
     */
    public ContactType getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactType }
     *     
     */
    public void setContact(ContactType value) {
        this.contact = value;
    }

    /**
     * Gets the value of the bank property.
     * 
     * @return
     *     possible object is
     *     {@link BankType }
     *     
     */
    public BankType getBank() {
        return bank;
    }

    /**
     * Sets the value of the bank property.
     * 
     * @param value
     *     allowed object is
     *     {@link BankType }
     *     
     */
    public void setBank(BankType value) {
        this.bank = value;
    }

    /**
     * Gets the value of the note property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getNote() {
        return note;
    }

    /**
     * Sets the value of the note property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setNote(Object value) {
        this.note = value;
    }

}
