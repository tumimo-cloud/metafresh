//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.03.15 at 05:39:15 PM CET 
//


package de.metas.edi.esb.jaxb.metasfresh;

import java.math.BigDecimal;
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
 * <p>Java class for EDI_cctop_invoic_vType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EDI_cctop_invoic_vType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="C_BPartner_Location_ID" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="C_Invoice_ID" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="CreditMemoReason" type="{}C_CreditMemo_ReasonEnum" minOccurs="0"/&gt;
 *         &lt;element name="DateInvoiced" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="DateOrdered" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="eancom_doctype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EDI_cctop_invoic_v_ID" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="GrandTotal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="invoice_documentno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ISO_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MovementDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="POReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="receivergln" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sendergln" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="shipment_documentno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TotalLines" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="totaltaxbaseamt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="totalvat" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="EDI_cctop_000_v" type="{}EDI_cctop_000_vType" minOccurs="0"/&gt;
 *         &lt;element name="EDI_cctop_111_v" type="{}EDI_cctop_111_vType" minOccurs="0"/&gt;
 *         &lt;element name="EDI_cctop_119_v" type="{}EDI_cctop_119_vType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="EDI_cctop_120_v" type="{}EDI_cctop_120_vType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="EDI_cctop_140_v" type="{}EDI_cctop_140_vType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="EDI_cctop_invoic_500_v" type="{}EDI_cctop_invoic_500_vType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="EDI_cctop_901_991_v" type="{}EDI_cctop_901_991_vType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="CountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CountryCode_3digit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CreditMemoReasonText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="VATaxID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="InvoicableQtyBasedOn" type="{}InvoicableQtyBasedOnEnum" minOccurs="0"/&gt;
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
@XmlType(name = "EDI_cctop_invoic_vType", propOrder = {
    "cbPartnerLocationID",
    "cInvoiceID",
    "creditMemoReason",
    "dateInvoiced",
    "dateOrdered",
    "eancomDoctype",
    "ediCctopInvoicVID",
    "grandTotal",
    "invoiceDocumentno",
    "isoCode",
    "movementDate",
    "poReference",
    "receivergln",
    "sendergln",
    "shipmentDocumentno",
    "totalLines",
    "totaltaxbaseamt",
    "totalvat",
    "ediCctop000V",
    "ediCctop111V",
    "ediCctop119V",
    "ediCctop120V",
    "ediCctop140V",
    "ediCctopInvoic500V",
    "ediCctop901991V",
    "countryCode",
    "countryCode3Digit",
    "creditMemoReasonText",
    "vaTaxID",
    "invoicableQtyBasedOn"
})
public class EDICctopInvoicVType {

    @XmlElement(name = "C_BPartner_Location_ID")
    protected BigInteger cbPartnerLocationID;
    @XmlElement(name = "C_Invoice_ID")
    protected BigInteger cInvoiceID;
    @XmlElement(name = "CreditMemoReason")
    @XmlSchemaType(name = "string")
    protected CCreditMemoReasonEnum creditMemoReason;
    @XmlElement(name = "DateInvoiced")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateInvoiced;
    @XmlElement(name = "DateOrdered")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOrdered;
    @XmlElement(name = "eancom_doctype")
    protected String eancomDoctype;
    @XmlElement(name = "EDI_cctop_invoic_v_ID")
    protected BigInteger ediCctopInvoicVID;
    @XmlElement(name = "GrandTotal")
    protected BigDecimal grandTotal;
    @XmlElement(name = "invoice_documentno")
    protected String invoiceDocumentno;
    @XmlElement(name = "ISO_Code")
    protected String isoCode;
    @XmlElement(name = "MovementDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar movementDate;
    @XmlElement(name = "POReference")
    protected String poReference;
    protected String receivergln;
    protected String sendergln;
    @XmlElement(name = "shipment_documentno")
    protected String shipmentDocumentno;
    @XmlElement(name = "TotalLines")
    protected BigDecimal totalLines;
    protected BigDecimal totaltaxbaseamt;
    protected BigDecimal totalvat;
    @XmlElement(name = "EDI_cctop_000_v")
    protected EDICctop000VType ediCctop000V;
    @XmlElement(name = "EDI_cctop_111_v")
    protected EDICctop111VType ediCctop111V;
    @XmlElement(name = "EDI_cctop_119_v")
    protected List<EDICctop119VType> ediCctop119V;
    @XmlElement(name = "EDI_cctop_120_v")
    protected List<EDICctop120VType> ediCctop120V;
    @XmlElement(name = "EDI_cctop_140_v")
    protected List<EDICctop140VType> ediCctop140V;
    @XmlElement(name = "EDI_cctop_invoic_500_v")
    protected List<EDICctopInvoic500VType> ediCctopInvoic500V;
    @XmlElement(name = "EDI_cctop_901_991_v")
    protected List<EDICctop901991VType> ediCctop901991V;
    @XmlElement(name = "CountryCode")
    protected String countryCode;
    @XmlElement(name = "CountryCode_3digit")
    protected String countryCode3Digit;
    @XmlElement(name = "CreditMemoReasonText")
    protected String creditMemoReasonText;
    @XmlElement(name = "VATaxID")
    protected String vaTaxID;
    @XmlElement(name = "InvoicableQtyBasedOn")
    @XmlSchemaType(name = "string")
    protected InvoicableQtyBasedOnEnum invoicableQtyBasedOn;
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
     * Gets the value of the cbPartnerLocationID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCBPartnerLocationID() {
        return cbPartnerLocationID;
    }

    /**
     * Sets the value of the cbPartnerLocationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCBPartnerLocationID(BigInteger value) {
        this.cbPartnerLocationID = value;
    }

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
     * Gets the value of the creditMemoReason property.
     * 
     * @return
     *     possible object is
     *     {@link CCreditMemoReasonEnum }
     *     
     */
    public CCreditMemoReasonEnum getCreditMemoReason() {
        return creditMemoReason;
    }

    /**
     * Sets the value of the creditMemoReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link CCreditMemoReasonEnum }
     *     
     */
    public void setCreditMemoReason(CCreditMemoReasonEnum value) {
        this.creditMemoReason = value;
    }

    /**
     * Gets the value of the dateInvoiced property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateInvoiced() {
        return dateInvoiced;
    }

    /**
     * Sets the value of the dateInvoiced property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateInvoiced(XMLGregorianCalendar value) {
        this.dateInvoiced = value;
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
     * Gets the value of the eancomDoctype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEancomDoctype() {
        return eancomDoctype;
    }

    /**
     * Sets the value of the eancomDoctype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEancomDoctype(String value) {
        this.eancomDoctype = value;
    }

    /**
     * Gets the value of the ediCctopInvoicVID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getEDICctopInvoicVID() {
        return ediCctopInvoicVID;
    }

    /**
     * Sets the value of the ediCctopInvoicVID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setEDICctopInvoicVID(BigInteger value) {
        this.ediCctopInvoicVID = value;
    }

    /**
     * Gets the value of the grandTotal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    /**
     * Sets the value of the grandTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGrandTotal(BigDecimal value) {
        this.grandTotal = value;
    }

    /**
     * Gets the value of the invoiceDocumentno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceDocumentno() {
        return invoiceDocumentno;
    }

    /**
     * Sets the value of the invoiceDocumentno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceDocumentno(String value) {
        this.invoiceDocumentno = value;
    }

    /**
     * Gets the value of the isoCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOCode() {
        return isoCode;
    }

    /**
     * Sets the value of the isoCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOCode(String value) {
        this.isoCode = value;
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
     * Gets the value of the receivergln property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceivergln() {
        return receivergln;
    }

    /**
     * Sets the value of the receivergln property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceivergln(String value) {
        this.receivergln = value;
    }

    /**
     * Gets the value of the sendergln property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendergln() {
        return sendergln;
    }

    /**
     * Sets the value of the sendergln property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendergln(String value) {
        this.sendergln = value;
    }

    /**
     * Gets the value of the shipmentDocumentno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipmentDocumentno() {
        return shipmentDocumentno;
    }

    /**
     * Sets the value of the shipmentDocumentno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipmentDocumentno(String value) {
        this.shipmentDocumentno = value;
    }

    /**
     * Gets the value of the totalLines property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalLines() {
        return totalLines;
    }

    /**
     * Sets the value of the totalLines property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalLines(BigDecimal value) {
        this.totalLines = value;
    }

    /**
     * Gets the value of the totaltaxbaseamt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotaltaxbaseamt() {
        return totaltaxbaseamt;
    }

    /**
     * Sets the value of the totaltaxbaseamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotaltaxbaseamt(BigDecimal value) {
        this.totaltaxbaseamt = value;
    }

    /**
     * Gets the value of the totalvat property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalvat() {
        return totalvat;
    }

    /**
     * Sets the value of the totalvat property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalvat(BigDecimal value) {
        this.totalvat = value;
    }

    /**
     * Gets the value of the ediCctop000V property.
     * 
     * @return
     *     possible object is
     *     {@link EDICctop000VType }
     *     
     */
    public EDICctop000VType getEDICctop000V() {
        return ediCctop000V;
    }

    /**
     * Sets the value of the ediCctop000V property.
     * 
     * @param value
     *     allowed object is
     *     {@link EDICctop000VType }
     *     
     */
    public void setEDICctop000V(EDICctop000VType value) {
        this.ediCctop000V = value;
    }

    /**
     * Gets the value of the ediCctop111V property.
     * 
     * @return
     *     possible object is
     *     {@link EDICctop111VType }
     *     
     */
    public EDICctop111VType getEDICctop111V() {
        return ediCctop111V;
    }

    /**
     * Sets the value of the ediCctop111V property.
     * 
     * @param value
     *     allowed object is
     *     {@link EDICctop111VType }
     *     
     */
    public void setEDICctop111V(EDICctop111VType value) {
        this.ediCctop111V = value;
    }

    /**
     * Gets the value of the ediCctop119V property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ediCctop119V property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEDICctop119V().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EDICctop119VType }
     * 
     * 
     */
    public List<EDICctop119VType> getEDICctop119V() {
        if (ediCctop119V == null) {
            ediCctop119V = new ArrayList<EDICctop119VType>();
        }
        return this.ediCctop119V;
    }

    /**
     * Gets the value of the ediCctop120V property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ediCctop120V property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEDICctop120V().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EDICctop120VType }
     * 
     * 
     */
    public List<EDICctop120VType> getEDICctop120V() {
        if (ediCctop120V == null) {
            ediCctop120V = new ArrayList<EDICctop120VType>();
        }
        return this.ediCctop120V;
    }

    /**
     * Gets the value of the ediCctop140V property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ediCctop140V property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEDICctop140V().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EDICctop140VType }
     * 
     * 
     */
    public List<EDICctop140VType> getEDICctop140V() {
        if (ediCctop140V == null) {
            ediCctop140V = new ArrayList<EDICctop140VType>();
        }
        return this.ediCctop140V;
    }

    /**
     * Gets the value of the ediCctopInvoic500V property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ediCctopInvoic500V property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEDICctopInvoic500V().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EDICctopInvoic500VType }
     * 
     * 
     */
    public List<EDICctopInvoic500VType> getEDICctopInvoic500V() {
        if (ediCctopInvoic500V == null) {
            ediCctopInvoic500V = new ArrayList<EDICctopInvoic500VType>();
        }
        return this.ediCctopInvoic500V;
    }

    /**
     * Gets the value of the ediCctop901991V property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ediCctop901991V property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEDICctop901991V().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EDICctop901991VType }
     * 
     * 
     */
    public List<EDICctop901991VType> getEDICctop901991V() {
        if (ediCctop901991V == null) {
            ediCctop901991V = new ArrayList<EDICctop901991VType>();
        }
        return this.ediCctop901991V;
    }

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * Gets the value of the countryCode3Digit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode3Digit() {
        return countryCode3Digit;
    }

    /**
     * Sets the value of the countryCode3Digit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode3Digit(String value) {
        this.countryCode3Digit = value;
    }

    /**
     * Gets the value of the creditMemoReasonText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditMemoReasonText() {
        return creditMemoReasonText;
    }

    /**
     * Sets the value of the creditMemoReasonText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditMemoReasonText(String value) {
        this.creditMemoReasonText = value;
    }

    /**
     * Gets the value of the vaTaxID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVATaxID() {
        return vaTaxID;
    }

    /**
     * Sets the value of the vaTaxID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVATaxID(String value) {
        this.vaTaxID = value;
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
