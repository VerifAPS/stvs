//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.03 at 12:36:15 AM CET 
//


package edu.kit.iti.formal.stvs.logic.io.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://formal.iti.kit.edu/stvs/logic/io/xml}Code"/>
 *         &lt;element name="spec" type="{http://formal.iti.kit.edu/stvs/logic/io/xml}SpecificationTable"/>
 *         &lt;element name="testResult" type="{http://formal.iti.kit.edu/stvs/logic/io/xml}SpecificationTable"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "code",
    "spec",
    "testResult"
})
@XmlRootElement(name = "project")
public class Project {

    @XmlElement(required = true)
    protected Code code;
    @XmlElement(required = true)
    protected SpecificationTable spec;
    @XmlElement(required = true)
    protected SpecificationTable testResult;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link Code }
     *     
     */
    public Code getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link Code }
     *     
     */
    public void setCode(Code value) {
        this.code = value;
    }

    /**
     * Gets the value of the spec property.
     * 
     * @return
     *     possible object is
     *     {@link SpecificationTable }
     *     
     */
    public SpecificationTable getSpec() {
        return spec;
    }

    /**
     * Sets the value of the spec property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecificationTable }
     *     
     */
    public void setSpec(SpecificationTable value) {
        this.spec = value;
    }

    /**
     * Gets the value of the testResult property.
     * 
     * @return
     *     possible object is
     *     {@link SpecificationTable }
     *     
     */
    public SpecificationTable getTestResult() {
        return testResult;
    }

    /**
     * Sets the value of the testResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecificationTable }
     *     
     */
    public void setTestResult(SpecificationTable value) {
        this.testResult = value;
    }

}
