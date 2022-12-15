//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.15 at 12:07:00 PM WAT 
//


package de.metas.edi.esb.jaxb.metasfresh;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for EDI_cctop_140_vType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EDI_cctop_140_vType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="C_Invoice_ID" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="Discount" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="DiscountDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="DiscountDays" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="EDI_cctop_140_v_ID" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="Rate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EDI_cctop_140_vType", propOrder = {
    "cInvoiceID",
    "discount",
    "discountDate",
    "discountDays",
    "ediCctop140VID",
    "rate"
})
public class EDICctop140VType {

    @XmlElement(name = "C_Invoice_ID")
    protected BigInteger cInvoiceID;
    @XmlElement(name = "Discount")
    protected BigInteger discount;
    @XmlElement(name = "DiscountDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar discountDate;
    @XmlElement(name = "DiscountDays")
    protected BigInteger discountDays;
    @XmlElement(name = "EDI_cctop_140_v_ID")
    protected BigInteger ediCctop140VID;
    @XmlElement(name = "Rate")
    protected BigDecimal rate;

    /**
     * Gets the value of the cInvoiceID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCInvoiceID() {
        return cInvoiceID;
    }

    /**
     * Sets the value of the cInvoiceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCInvoiceID(BigInteger value) {
        this.cInvoiceID = value;
    }

    /**
     * Gets the value of the discount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDiscount() {
        return discount;
    }

    /**
     * Sets the value of the discount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDiscount(BigInteger value) {
        this.discount = value;
    }

    /**
     * Gets the value of the discountDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDiscountDate() {
        return discountDate;
    }

    /**
     * Sets the value of the discountDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDiscountDate(XMLGregorianCalendar value) {
        this.discountDate = value;
    }

    /**
     * Gets the value of the discountDays property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDiscountDays() {
        return discountDays;
    }

    /**
     * Sets the value of the discountDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDiscountDays(BigInteger value) {
        this.discountDays = value;
    }

    /**
     * Gets the value of the ediCctop140VID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getEDICctop140VID() {
        return ediCctop140VID;
    }

    /**
     * Sets the value of the ediCctop140VID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setEDICctop140VID(BigInteger value) {
        this.ediCctop140VID = value;
    }

    /**
     * Gets the value of the rate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRate(BigDecimal value) {
        this.rate = value;
    }

}
