//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.09 at 05:46:30 PM CET 
//


package de.metas.edi.esb.jaxb.metasfresh;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for C_Order_DeliveryViaRuleEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="C_Order_DeliveryViaRuleEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="P"/&gt;
 *     &lt;enumeration value="S"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "C_Order_DeliveryViaRuleEnum")
@XmlEnum
public enum COrderDeliveryViaRuleEnum {

    @XmlEnumValue("P")
    Pickup("P"),
    @XmlEnumValue("S")
    Shipper("S");
    private final String value;

    COrderDeliveryViaRuleEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static COrderDeliveryViaRuleEnum fromValue(String v) {
        for (COrderDeliveryViaRuleEnum c: COrderDeliveryViaRuleEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
