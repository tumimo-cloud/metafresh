//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.12 at 05:52:46 PM EET 
//


package de.metas.edi.esb.jaxb.metasfresh;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for EDI_Exp_DesadvType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EDI_Exp_DesadvType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="C_BPartner_ID" type="{}EDI_Exp_C_BPartnerType" minOccurs="0"/&gt;
 *         &lt;element name="C_BPartner_Location_ID" type="{}EDI_Exp_C_BPartner_LocationType" minOccurs="0"/&gt;
 *         &lt;element name="DateOrdered" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="DocumentNo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="EDI_Desadv_ID" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="EDI_ExportStatus" type="{}EDI_ExportStatusEnum"/&gt;
 *         &lt;element name="MovementDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="POReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EDI_Exp_Desadv_Pack" type="{}EDI_Exp_Desadv_PackType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Bill_Location_ID" type="{}EDI_Exp_C_BPartner_LocationType" minOccurs="0"/&gt;
 *         &lt;element name="C_Currency_ID" type="{}EDI_Exp_C_CurrencyType" minOccurs="0"/&gt;
 *         &lt;element name="HandOver_Location_ID" type="{}EDI_Exp_C_BPartner_LocationType" minOccurs="0"/&gt;
 *         &lt;element name="DropShip_BPartner_ID" type="{}EDI_Exp_C_BPartnerType" minOccurs="0"/&gt;
 *         &lt;element name="DropShip_Location_ID" type="{}EDI_Exp_C_BPartner_LocationType" minOccurs="0"/&gt;
 *         &lt;element name="HandOver_Partner_ID" type="{}EDI_Exp_C_BPartnerType" minOccurs="0"/&gt;
 *         &lt;element name="InvoicableQtyBasedOn" type="{}InvoicableQtyBasedOnEnum" minOccurs="0"/&gt;
 *         &lt;element name="DeliveryViaRule" type="{}C_Order_DeliveryViaRuleEnum" minOccurs="0"/&gt;
 *         &lt;element name="EDI_Exp_DesadvLineWithNoPack" type="{}EDI_Exp_DesadvLineWithNoPackType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{}AD_Client_Value"/&gt;
 *       &lt;attribute ref="{}ReplicationEvent"/&gt;
 *       &lt;attribute ref="{}ReplicationMode"/&gt;
 *       &lt;attribute ref="{}ReplicationType"/&gt;
 *       &lt;attribute name="Version" type="{http://www.w3.org/2001/XMLSchema}string" fixed="*" /&gt;
 *       &lt;attribute ref="{}SequenceNo"/&gt;
 *       &lt;attribute ref="{}TrxName"/&gt;
 *       &lt;attribute ref="{}AD_Session_ID"/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EDI_Exp_DesadvType", propOrder = {
    "cbPartnerID",
    "cbPartnerLocationID",
    "dateOrdered",
    "documentNo",
    "ediDesadvID",
    "ediExportStatus",
    "movementDate",
    "poReference",
    "ediExpDesadvPack",
    "billLocationID",
    "cCurrencyID",
    "handOverLocationID",
    "dropShipBPartnerID",
    "dropShipLocationID",
    "handOverPartnerID",
    "invoicableQtyBasedOn",
    "deliveryViaRule",
    "ediExpDesadvLineWithNoPack"
})
public class EDIExpDesadvType {

    @XmlElement(name = "C_BPartner_ID")
    protected EDIExpCBPartnerType cbPartnerID;
    @XmlElement(name = "C_BPartner_Location_ID")
    protected EDIExpCBPartnerLocationType cbPartnerLocationID;
    @XmlElement(name = "DateOrdered")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOrdered;
    @XmlElement(name = "DocumentNo", required = true)
    protected String documentNo;
    @XmlElement(name = "EDI_Desadv_ID", required = true)
    protected BigInteger ediDesadvID;
    @XmlElement(name = "EDI_ExportStatus", required = true)
    @XmlSchemaType(name = "string")
    protected EDIExportStatusEnum ediExportStatus;
    @XmlElement(name = "MovementDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar movementDate;
    @XmlElement(name = "POReference")
    protected String poReference;
    @XmlElement(name = "EDI_Exp_Desadv_Pack")
    protected List<EDIExpDesadvPackType> ediExpDesadvPack;
    @XmlElement(name = "Bill_Location_ID")
    protected EDIExpCBPartnerLocationType billLocationID;
    @XmlElement(name = "C_Currency_ID")
    protected EDIExpCCurrencyType cCurrencyID;
    @XmlElement(name = "HandOver_Location_ID")
    protected EDIExpCBPartnerLocationType handOverLocationID;
    @XmlElement(name = "DropShip_BPartner_ID")
    protected EDIExpCBPartnerType dropShipBPartnerID;
    @XmlElement(name = "DropShip_Location_ID")
    protected EDIExpCBPartnerLocationType dropShipLocationID;
    @XmlElement(name = "HandOver_Partner_ID")
    protected EDIExpCBPartnerType handOverPartnerID;
    @XmlElement(name = "InvoicableQtyBasedOn")
    @XmlSchemaType(name = "string")
    protected InvoicableQtyBasedOnEnum invoicableQtyBasedOn;
    @XmlElement(name = "DeliveryViaRule")
    @XmlSchemaType(name = "string")
    protected COrderDeliveryViaRuleEnum deliveryViaRule;
    @XmlElement(name = "EDI_Exp_DesadvLineWithNoPack")
    protected List<EDIExpDesadvLineWithNoPackType> ediExpDesadvLineWithNoPack;
    @XmlAttribute(name = "AD_Client_Value")
    protected String adClientValueAttr;
    @XmlAttribute(name = "ReplicationEvent")
    protected ReplicationEventEnum replicationEventAttr;
    @XmlAttribute(name = "ReplicationMode")
    protected ReplicationModeEnum replicationModeAttr;
    @XmlAttribute(name = "ReplicationType")
    protected ReplicationTypeEnum replicationTypeAttr;
    @XmlAttribute(name = "Version")
    protected String versionAttr;
    @XmlAttribute(name = "SequenceNo")
    protected BigInteger sequenceNoAttr;
    @XmlAttribute(name = "TrxName")
    protected String trxNameAttr;
    @XmlAttribute(name = "AD_Session_ID")
    protected BigInteger adSessionIDAttr;

    /**
     * Gets the value of the cbPartnerID property.
     * 
     * @return
     *     possible object is
     *     {@link EDIExpCBPartnerType }
     *     
     */
    public EDIExpCBPartnerType getCBPartnerID() {
        return cbPartnerID;
    }

    /**
     * Sets the value of the cbPartnerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link EDIExpCBPartnerType }
     *     
     */
    public void setCBPartnerID(EDIExpCBPartnerType value) {
        this.cbPartnerID = value;
    }

    /**
     * Gets the value of the cbPartnerLocationID property.
     * 
     * @return
     *     possible object is
     *     {@link EDIExpCBPartnerLocationType }
     *     
     */
    public EDIExpCBPartnerLocationType getCBPartnerLocationID() {
        return cbPartnerLocationID;
    }

    /**
     * Sets the value of the cbPartnerLocationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link EDIExpCBPartnerLocationType }
     *     
     */
    public void setCBPartnerLocationID(EDIExpCBPartnerLocationType value) {
        this.cbPartnerLocationID = value;
    }

    /**
     * Gets the value of the dateOrdered property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOrdered() {
        return dateOrdered;
    }

    /**
     * Sets the value of the dateOrdered property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOrdered(XMLGregorianCalendar value) {
        this.dateOrdered = value;
    }

    /**
     * Gets the value of the documentNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentNo() {
        return documentNo;
    }

    /**
     * Sets the value of the documentNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentNo(String value) {
        this.documentNo = value;
    }

    /**
     * Gets the value of the ediDesadvID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getEDIDesadvID() {
        return ediDesadvID;
    }

    /**
     * Sets the value of the ediDesadvID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setEDIDesadvID(BigInteger value) {
        this.ediDesadvID = value;
    }

    /**
     * Gets the value of the ediExportStatus property.
     * 
     * @return
     *     possible object is
     *     {@link EDIExportStatusEnum }
     *     
     */
    public EDIExportStatusEnum getEDIExportStatus() {
        return ediExportStatus;
    }

    /**
     * Sets the value of the ediExportStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link EDIExportStatusEnum }
     *     
     */
    public void setEDIExportStatus(EDIExportStatusEnum value) {
        this.ediExportStatus = value;
    }

    /**
     * Gets the value of the movementDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMovementDate() {
        return movementDate;
    }

    /**
     * Sets the value of the movementDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMovementDate(XMLGregorianCalendar value) {
        this.movementDate = value;
    }

    /**
     * Gets the value of the poReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOReference() {
        return poReference;
    }

    /**
     * Sets the value of the poReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOReference(String value) {
        this.poReference = value;
    }

    /**
     * Gets the value of the ediExpDesadvPack property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ediExpDesadvPack property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEDIExpDesadvPack().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EDIExpDesadvPackType }
     * 
     * 
     */
    public List<EDIExpDesadvPackType> getEDIExpDesadvPack() {
        if (ediExpDesadvPack == null) {
            ediExpDesadvPack = new ArrayList<EDIExpDesadvPackType>();
        }
        return this.ediExpDesadvPack;
    }

    /**
     * Gets the value of the billLocationID property.
     * 
     * @return
     *     possible object is
     *     {@link EDIExpCBPartnerLocationType }
     *     
     */
    public EDIExpCBPartnerLocationType getBillLocationID() {
        return billLocationID;
    }

    /**
     * Sets the value of the billLocationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link EDIExpCBPartnerLocationType }
     *     
     */
    public void setBillLocationID(EDIExpCBPartnerLocationType value) {
        this.billLocationID = value;
    }

    /**
     * Gets the value of the cCurrencyID property.
     * 
     * @return
     *     possible object is
     *     {@link EDIExpCCurrencyType }
     *     
     */
    public EDIExpCCurrencyType getCCurrencyID() {
        return cCurrencyID;
    }

    /**
     * Sets the value of the cCurrencyID property.
     * 
     * @param value
     *     allowed object is
     *     {@link EDIExpCCurrencyType }
     *     
     */
    public void setCCurrencyID(EDIExpCCurrencyType value) {
        this.cCurrencyID = value;
    }

    /**
     * Gets the value of the handOverLocationID property.
     * 
     * @return
     *     possible object is
     *     {@link EDIExpCBPartnerLocationType }
     *     
     */
    public EDIExpCBPartnerLocationType getHandOverLocationID() {
        return handOverLocationID;
    }

    /**
     * Sets the value of the handOverLocationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link EDIExpCBPartnerLocationType }
     *     
     */
    public void setHandOverLocationID(EDIExpCBPartnerLocationType value) {
        this.handOverLocationID = value;
    }

    /**
     * Gets the value of the dropShipBPartnerID property.
     * 
     * @return
     *     possible object is
     *     {@link EDIExpCBPartnerType }
     *     
     */
    public EDIExpCBPartnerType getDropShipBPartnerID() {
        return dropShipBPartnerID;
    }

    /**
     * Sets the value of the dropShipBPartnerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link EDIExpCBPartnerType }
     *     
     */
    public void setDropShipBPartnerID(EDIExpCBPartnerType value) {
        this.dropShipBPartnerID = value;
    }

    /**
     * Gets the value of the dropShipLocationID property.
     * 
     * @return
     *     possible object is
     *     {@link EDIExpCBPartnerLocationType }
     *     
     */
    public EDIExpCBPartnerLocationType getDropShipLocationID() {
        return dropShipLocationID;
    }

    /**
     * Sets the value of the dropShipLocationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link EDIExpCBPartnerLocationType }
     *     
     */
    public void setDropShipLocationID(EDIExpCBPartnerLocationType value) {
        this.dropShipLocationID = value;
    }

    /**
     * Gets the value of the handOverPartnerID property.
     * 
     * @return
     *     possible object is
     *     {@link EDIExpCBPartnerType }
     *     
     */
    public EDIExpCBPartnerType getHandOverPartnerID() {
        return handOverPartnerID;
    }

    /**
     * Sets the value of the handOverPartnerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link EDIExpCBPartnerType }
     *     
     */
    public void setHandOverPartnerID(EDIExpCBPartnerType value) {
        this.handOverPartnerID = value;
    }

    /**
     * Gets the value of the invoicableQtyBasedOn property.
     * 
     * @return
     *     possible object is
     *     {@link InvoicableQtyBasedOnEnum }
     *     
     */
    public InvoicableQtyBasedOnEnum getInvoicableQtyBasedOn() {
        return invoicableQtyBasedOn;
    }

    /**
     * Sets the value of the invoicableQtyBasedOn property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoicableQtyBasedOnEnum }
     *     
     */
    public void setInvoicableQtyBasedOn(InvoicableQtyBasedOnEnum value) {
        this.invoicableQtyBasedOn = value;
    }

    /**
     * Gets the value of the deliveryViaRule property.
     * 
     * @return
     *     possible object is
     *     {@link COrderDeliveryViaRuleEnum }
     *     
     */
    public COrderDeliveryViaRuleEnum getDeliveryViaRule() {
        return deliveryViaRule;
    }

    /**
     * Sets the value of the deliveryViaRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link COrderDeliveryViaRuleEnum }
     *     
     */
    public void setDeliveryViaRule(COrderDeliveryViaRuleEnum value) {
        this.deliveryViaRule = value;
    }

    /**
     * Gets the value of the ediExpDesadvLineWithNoPack property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ediExpDesadvLineWithNoPack property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEDIExpDesadvLineWithNoPack().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EDIExpDesadvLineWithNoPackType }
     * 
     * 
     */
    public List<EDIExpDesadvLineWithNoPackType> getEDIExpDesadvLineWithNoPack() {
        if (ediExpDesadvLineWithNoPack == null) {
            ediExpDesadvLineWithNoPack = new ArrayList<EDIExpDesadvLineWithNoPackType>();
        }
        return this.ediExpDesadvLineWithNoPack;
    }

    /**
     * Gets the value of the adClientValueAttr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADClientValueAttr() {
        return adClientValueAttr;
    }

    /**
     * Sets the value of the adClientValueAttr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADClientValueAttr(String value) {
        this.adClientValueAttr = value;
    }

    /**
     * Gets the value of the replicationEventAttr property.
     * 
     * @return
     *     possible object is
     *     {@link ReplicationEventEnum }
     *     
     */
    public ReplicationEventEnum getReplicationEventAttr() {
        return replicationEventAttr;
    }

    /**
     * Sets the value of the replicationEventAttr property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplicationEventEnum }
     *     
     */
    public void setReplicationEventAttr(ReplicationEventEnum value) {
        this.replicationEventAttr = value;
    }

    /**
     * Gets the value of the replicationModeAttr property.
     * 
     * @return
     *     possible object is
     *     {@link ReplicationModeEnum }
     *     
     */
    public ReplicationModeEnum getReplicationModeAttr() {
        return replicationModeAttr;
    }

    /**
     * Sets the value of the replicationModeAttr property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplicationModeEnum }
     *     
     */
    public void setReplicationModeAttr(ReplicationModeEnum value) {
        this.replicationModeAttr = value;
    }

    /**
     * Gets the value of the replicationTypeAttr property.
     * 
     * @return
     *     possible object is
     *     {@link ReplicationTypeEnum }
     *     
     */
    public ReplicationTypeEnum getReplicationTypeAttr() {
        return replicationTypeAttr;
    }

    /**
     * Sets the value of the replicationTypeAttr property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplicationTypeEnum }
     *     
     */
    public void setReplicationTypeAttr(ReplicationTypeEnum value) {
        this.replicationTypeAttr = value;
    }

    /**
     * Gets the value of the versionAttr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersionAttr() {
        if (versionAttr == null) {
            return "*";
        } else {
            return versionAttr;
        }
    }

    /**
     * Sets the value of the versionAttr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersionAttr(String value) {
        this.versionAttr = value;
    }

    /**
     * Gets the value of the sequenceNoAttr property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSequenceNoAttr() {
        return sequenceNoAttr;
    }

    /**
     * Sets the value of the sequenceNoAttr property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSequenceNoAttr(BigInteger value) {
        this.sequenceNoAttr = value;
    }

    /**
     * Gets the value of the trxNameAttr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrxNameAttr() {
        return trxNameAttr;
    }

    /**
     * Sets the value of the trxNameAttr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrxNameAttr(String value) {
        this.trxNameAttr = value;
    }

    /**
     * Gets the value of the adSessionIDAttr property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getADSessionIDAttr() {
        return adSessionIDAttr;
    }

    /**
     * Sets the value of the adSessionIDAttr property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setADSessionIDAttr(BigInteger value) {
        this.adSessionIDAttr = value;
    }

}
