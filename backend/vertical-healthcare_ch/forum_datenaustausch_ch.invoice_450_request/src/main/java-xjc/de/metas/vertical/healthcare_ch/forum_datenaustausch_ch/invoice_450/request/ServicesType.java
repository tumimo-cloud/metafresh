//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.09 at 05:47:07 PM CET 
//


package de.metas.vertical.healthcare_ch.forum_datenaustausch_ch.invoice_450.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for servicesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="servicesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded"&gt;
 *         &lt;element name="service_ex" type="{http://www.forum-datenaustausch.ch/invoice}serviceExType"/&gt;
 *         &lt;element name="service" type="{http://www.forum-datenaustausch.ch/invoice}serviceType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "servicesType", namespace = "http://www.forum-datenaustausch.ch/invoice", propOrder = {
    "serviceExOrService"
})
public class ServicesType {

    @XmlElements({
        @XmlElement(name = "service_ex", namespace = "http://www.forum-datenaustausch.ch/invoice", type = ServiceExType.class),
        @XmlElement(name = "service", namespace = "http://www.forum-datenaustausch.ch/invoice", type = ServiceType.class)
    })
    protected List<Object> serviceExOrService;

    /**
     * Gets the value of the serviceExOrService property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceExOrService property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceExOrService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceExType }
     * {@link ServiceType }
     * 
     * 
     */
    public List<Object> getServiceExOrService() {
        if (serviceExOrService == null) {
            serviceExOrService = new ArrayList<Object>();
        }
        return this.serviceExOrService;
    }

}
