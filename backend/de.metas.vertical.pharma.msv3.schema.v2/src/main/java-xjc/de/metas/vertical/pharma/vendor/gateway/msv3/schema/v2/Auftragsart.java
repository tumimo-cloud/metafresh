//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.09 at 05:38:20 PM CET 
//


package de.metas.vertical.pharma.vendor.gateway.msv3.schema.v2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Auftragsart.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Auftragsart"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="NORMAL"/&gt;
 *     &lt;enumeration value="STAPEL"/&gt;
 *     &lt;enumeration value="SONDER"/&gt;
 *     &lt;enumeration value="VERSAND"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Auftragsart")
@XmlEnum
public enum Auftragsart {

    NORMAL,
    STAPEL,
    SONDER,
    VERSAND;

    public String value() {
        return name();
    }

    public static Auftragsart fromValue(String v) {
        return valueOf(v);
    }

}
