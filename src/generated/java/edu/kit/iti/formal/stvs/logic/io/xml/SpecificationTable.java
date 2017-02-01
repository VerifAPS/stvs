//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.01 at 07:53:18 AM CET 
//


package edu.kit.iti.formal.stvs.logic.io.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import edu.kit.iti.formal.exteta_1.TestTable;


/**
 * <p>Java class for SpecificationTable complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SpecificationTable">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="filename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="test-table" type="{http://formal.iti.kit.edu/exteta-1.0}testTable"/>
 *         &lt;element name="display-info" type="{http://formal.iti.kit.edu/stvs/logic/io/xml}DisplayInfo" minOccurs="0"/>
 *         &lt;element name="additional-info" type="{http://formal.iti.kit.edu/stvs/logic/io/xml}AdditionalInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpecificationTable", propOrder = {
    "filename",
    "testTable",
    "displayInfo",
    "additionalInfo"
})
public class SpecificationTable {

    protected String filename;
    @XmlElement(name = "test-table", required = true)
    protected TestTable testTable;
    @XmlElement(name = "display-info")
    protected DisplayInfo displayInfo;
    @XmlElement(name = "additional-info")
    protected AdditionalInfo additionalInfo;

    /**
     * Gets the value of the filename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Sets the value of the filename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilename(String value) {
        this.filename = value;
    }

    /**
     * Gets the value of the testTable property.
     * 
     * @return
     *     possible object is
     *     {@link TestTable }
     *     
     */
    public TestTable getTestTable() {
        return testTable;
    }

    /**
     * Sets the value of the testTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link TestTable }
     *     
     */
    public void setTestTable(TestTable value) {
        this.testTable = value;
    }

    /**
     * Gets the value of the displayInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DisplayInfo }
     *     
     */
    public DisplayInfo getDisplayInfo() {
        return displayInfo;
    }

    /**
     * Sets the value of the displayInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayInfo }
     *     
     */
    public void setDisplayInfo(DisplayInfo value) {
        this.displayInfo = value;
    }

    /**
     * Gets the value of the additionalInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalInfo }
     *     
     */
    public AdditionalInfo getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Sets the value of the additionalInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalInfo }
     *     
     */
    public void setAdditionalInfo(AdditionalInfo value) {
        this.additionalInfo = value;
    }

}
