//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.03.15 at 05:11:54 PM EET 
//


package de.metas.vertical.healthcare_ch.forum_datenaustausch_ch.invoice_450.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bodyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bodyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="prolog" type="{http://www.forum-datenaustausch.ch/invoice}prologType"/&gt;
 *         &lt;element name="biller" type="{http://www.forum-datenaustausch.ch/invoice}partyType"/&gt;
 *         &lt;element name="debitor" type="{http://www.forum-datenaustausch.ch/invoice}partyType"/&gt;
 *         &lt;element name="provider" type="{http://www.forum-datenaustausch.ch/invoice}partyType"/&gt;
 *         &lt;element name="insurance" type="{http://www.forum-datenaustausch.ch/invoice}partyType"/&gt;
 *         &lt;element name="patient" type="{http://www.forum-datenaustausch.ch/invoice}patientAddressType"/&gt;
 *         &lt;element name="treatment" type="{http://www.forum-datenaustausch.ch/invoice}treatmentType" minOccurs="0"/&gt;
 *         &lt;element name="contact" type="{http://www.forum-datenaustausch.ch/invoice}contactAddressType"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="pending" type="{http://www.forum-datenaustausch.ch/invoice}pendingType"/&gt;
 *           &lt;element name="accepted" type="{http://www.forum-datenaustausch.ch/invoice}acceptedType"/&gt;
 *           &lt;element name="rejected" type="{http://www.forum-datenaustausch.ch/invoice}rejectedType"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="documents" type="{http://www.forum-datenaustausch.ch/invoice}documentsType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bodyType", propOrder = {
    "prolog",
    "biller",
    "debitor",
    "provider",
    "insurance",
    "patient",
    "treatment",
    "contact",
    "pending",
    "accepted",
    "rejected",
    "documents"
})
public class BodyType {

    @XmlElement(required = true)
    protected PrologType prolog;
    @XmlElement(required = true)
    protected PartyType biller;
    @XmlElement(required = true)
    protected PartyType debitor;
    @XmlElement(required = true)
    protected PartyType provider;
    @XmlElement(required = true)
    protected PartyType insurance;
    @XmlElement(required = true)
    protected PatientAddressType patient;
    protected TreatmentType treatment;
    @XmlElement(required = true)
    protected ContactAddressType contact;
    protected PendingType pending;
    protected AcceptedType accepted;
    protected RejectedType rejected;
    protected DocumentsType documents;

    /**
     * Gets the value of the prolog property.
     * 
     * @return
     *     possible object is
     *     {@link PrologType }
     *     
     */
    public PrologType getProlog() {
        return prolog;
    }

    /**
     * Sets the value of the prolog property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrologType }
     *     
     */
    public void setProlog(PrologType value) {
        this.prolog = value;
    }

    /**
     * Gets the value of the biller property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getBiller() {
        return biller;
    }

    /**
     * Sets the value of the biller property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setBiller(PartyType value) {
        this.biller = value;
    }

    /**
     * Gets the value of the debitor property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getDebitor() {
        return debitor;
    }

    /**
     * Sets the value of the debitor property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setDebitor(PartyType value) {
        this.debitor = value;
    }

    /**
     * Gets the value of the provider property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getProvider() {
        return provider;
    }

    /**
     * Sets the value of the provider property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setProvider(PartyType value) {
        this.provider = value;
    }

    /**
     * Gets the value of the insurance property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getInsurance() {
        return insurance;
    }

    /**
     * Sets the value of the insurance property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setInsurance(PartyType value) {
        this.insurance = value;
    }

    /**
     * Gets the value of the patient property.
     * 
     * @return
     *     possible object is
     *     {@link PatientAddressType }
     *     
     */
    public PatientAddressType getPatient() {
        return patient;
    }

    /**
     * Sets the value of the patient property.
     * 
     * @param value
     *     allowed object is
     *     {@link PatientAddressType }
     *     
     */
    public void setPatient(PatientAddressType value) {
        this.patient = value;
    }

    /**
     * Gets the value of the treatment property.
     * 
     * @return
     *     possible object is
     *     {@link TreatmentType }
     *     
     */
    public TreatmentType getTreatment() {
        return treatment;
    }

    /**
     * Sets the value of the treatment property.
     * 
     * @param value
     *     allowed object is
     *     {@link TreatmentType }
     *     
     */
    public void setTreatment(TreatmentType value) {
        this.treatment = value;
    }

    /**
     * Gets the value of the contact property.
     * 
     * @return
     *     possible object is
     *     {@link ContactAddressType }
     *     
     */
    public ContactAddressType getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactAddressType }
     *     
     */
    public void setContact(ContactAddressType value) {
        this.contact = value;
    }

    /**
     * Gets the value of the pending property.
     * 
     * @return
     *     possible object is
     *     {@link PendingType }
     *     
     */
    public PendingType getPending() {
        return pending;
    }

    /**
     * Sets the value of the pending property.
     * 
     * @param value
     *     allowed object is
     *     {@link PendingType }
     *     
     */
    public void setPending(PendingType value) {
        this.pending = value;
    }

    /**
     * Gets the value of the accepted property.
     * 
     * @return
     *     possible object is
     *     {@link AcceptedType }
     *     
     */
    public AcceptedType getAccepted() {
        return accepted;
    }

    /**
     * Sets the value of the accepted property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcceptedType }
     *     
     */
    public void setAccepted(AcceptedType value) {
        this.accepted = value;
    }

    /**
     * Gets the value of the rejected property.
     * 
     * @return
     *     possible object is
     *     {@link RejectedType }
     *     
     */
    public RejectedType getRejected() {
        return rejected;
    }

    /**
     * Sets the value of the rejected property.
     * 
     * @param value
     *     allowed object is
     *     {@link RejectedType }
     *     
     */
    public void setRejected(RejectedType value) {
        this.rejected = value;
    }

    /**
     * Gets the value of the documents property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentsType }
     *     
     */
    public DocumentsType getDocuments() {
        return documents;
    }

    /**
     * Sets the value of the documents property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentsType }
     *     
     */
    public void setDocuments(DocumentsType value) {
        this.documents = value;
    }

}
