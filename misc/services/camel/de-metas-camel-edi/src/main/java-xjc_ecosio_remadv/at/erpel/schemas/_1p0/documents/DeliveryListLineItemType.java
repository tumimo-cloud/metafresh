//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.06 at 03:38:18 PM CET 
//


package at.erpel.schemas._1p0.documents;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeliveryListLineItemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeliveryListLineItemType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents}ConsignmentPackagingSequence"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliveryListLineItemType", propOrder = {
    "consignmentPackagingSequence"
})
public class DeliveryListLineItemType {

    @XmlElement(name = "ConsignmentPackagingSequence", required = true)
    protected ConsignmentPackagingSequenceType consignmentPackagingSequence;

    /**
     * Used to identify the sequence in which physical packing is presented in the consignment, and optionally to identify the hierarchical relationship between packing layers. Note: This element is used in order to allow for compliance to EDIFACT DESADVs.
     * 
     * @return
     *     possible object is
     *     {@link ConsignmentPackagingSequenceType }
     *     
     */
    public ConsignmentPackagingSequenceType getConsignmentPackagingSequence() {
        return consignmentPackagingSequence;
    }

    /**
     * Sets the value of the consignmentPackagingSequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsignmentPackagingSequenceType }
     *     
     */
    public void setConsignmentPackagingSequence(ConsignmentPackagingSequenceType value) {
        this.consignmentPackagingSequence = value;
    }

}
