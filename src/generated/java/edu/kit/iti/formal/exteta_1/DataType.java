//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.16 at 10:35:48 PM CET 
//


package edu.kit.iti.formal.exteta_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="dataType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ENUM"/>
 *     &lt;enumeration value="INT"/>
 *     &lt;enumeration value="SINT"/>
 *     &lt;enumeration value="LINT"/>
 *     &lt;enumeration value="DINT"/>
 *     &lt;enumeration value="UINT"/>
 *     &lt;enumeration value="UDINT"/>
 *     &lt;enumeration value="ULINT"/>
 *     &lt;enumeration value="USINT"/>
 *     &lt;enumeration value="BOOLEAN"/>
 *     &lt;enumeration value="BYTE"/>
 *     &lt;enumeration value="WORD"/>
 *     &lt;enumeration value="LWORD"/>
 *     &lt;enumeration value="DWORD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "dataType")
@XmlEnum
public enum DataType {

    ENUM,
    INT,
    SINT,
    LINT,
    DINT,
    UINT,
    UDINT,
    ULINT,
    USINT,
    BOOLEAN,
    BYTE,
    WORD,
    LWORD,
    DWORD;

    public String value() {
        return name();
    }

    public static DataType fromValue(String v) {
        return valueOf(v);
    }

}
