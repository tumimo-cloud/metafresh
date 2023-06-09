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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for xtraDrugType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="xtraDrugType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="indicated" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="iocm_category"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *             &lt;enumeration value="A"/&gt;
 *             &lt;enumeration value="B"/&gt;
 *             &lt;enumeration value="C"/&gt;
 *             &lt;enumeration value="D"/&gt;
 *             &lt;enumeration value="E"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="delivery" default="first"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *             &lt;enumeration value="first"/&gt;
 *             &lt;enumeration value="repeated"/&gt;
 *             &lt;enumeration value="permanent"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="regulation_attributes" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" default="0" /&gt;
 *       &lt;attribute name="limitation" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xtraDrugType", namespace = "http://www.forum-datenaustausch.ch/invoice")
public class XtraDrugType {

    @XmlAttribute(name = "indicated")
    protected Boolean indicated;
    @XmlAttribute(name = "iocm_category")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String iocmCategory;
    @XmlAttribute(name = "delivery")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String delivery;
    @XmlAttribute(name = "regulation_attributes")
    @XmlSchemaType(name = "unsignedInt")
    protected Long regulationAttributes;
    @XmlAttribute(name = "limitation")
    protected Boolean limitation;

    /**
     * Gets the value of the indicated property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIndicated() {
        return indicated;
    }

    /**
     * Sets the value of the indicated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIndicated(Boolean value) {
        this.indicated = value;
    }

    /**
     * Gets the value of the iocmCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIocmCategory() {
        return iocmCategory;
    }

    /**
     * Sets the value of the iocmCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIocmCategory(String value) {
        this.iocmCategory = value;
    }

    /**
     * Gets the value of the delivery property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelivery() {
        if (delivery == null) {
            return "first";
        } else {
            return delivery;
        }
    }

    /**
     * Sets the value of the delivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelivery(String value) {
        this.delivery = value;
    }

    /**
     * Gets the value of the regulationAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public long getRegulationAttributes() {
        if (regulationAttributes == null) {
            return  0L;
        } else {
            return regulationAttributes;
        }
    }

    /**
     * Sets the value of the regulationAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRegulationAttributes(Long value) {
        this.regulationAttributes = value;
    }

    /**
     * Gets the value of the limitation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLimitation() {
        return limitation;
    }

    /**
     * Sets the value of the limitation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLimitation(Boolean value) {
        this.limitation = value;
    }

}
