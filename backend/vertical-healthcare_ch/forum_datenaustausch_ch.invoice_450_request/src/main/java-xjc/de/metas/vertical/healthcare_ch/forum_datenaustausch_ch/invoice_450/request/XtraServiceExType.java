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


/**
 * <p>Java class for xtraServiceExType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="xtraServiceExType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="group_size" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" default="1" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xtraServiceExType", namespace = "http://www.forum-datenaustausch.ch/invoice")
public class XtraServiceExType {

    @XmlAttribute(name = "group_size")
    @XmlSchemaType(name = "unsignedInt")
    protected Long groupSize;

    /**
     * Gets the value of the groupSize property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public long getGroupSize() {
        if (groupSize == null) {
            return  1L;
        } else {
            return groupSize;
        }
    }

    /**
     * Sets the value of the groupSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGroupSize(Long value) {
        this.groupSize = value;
    }

}
