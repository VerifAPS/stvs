//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.16 at 10:35:48 PM CET 
//


package edu.kit.iti.formal.stvs.logic.io.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="variables" type="{http://formal.iti.kit.edu/stvs/logic/io/xml}Variables"/>
 *         &lt;element name="rows" type="{http://formal.iti.kit.edu/stvs/logic/io/xml}Rows" minOccurs="0"/>
 *         &lt;element name="enumTypes" type="{http://formal.iti.kit.edu/stvs/logic/io/xml}EnumTypes" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="isConcrete" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="isCounterExample" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="comment" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" default="Unnamed Specification" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpecificationTable", propOrder = {
    "variables",
    "rows",
    "enumTypes"
})
public class SpecificationTable {

    @XmlElement(required = true)
    protected Variables variables;
    protected Rows rows;
    protected EnumTypes enumTypes;
    @XmlAttribute(name = "isConcrete", required = true)
    protected boolean isConcrete;
    @XmlAttribute(name = "isCounterExample")
    protected Boolean isCounterExample;
    @XmlAttribute(name = "comment")
    protected String comment;
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Gets the value of the variables property.
     * 
     * @return
     *     possible object is
     *     {@link Variables }
     *     
     */
    public Variables getVariables() {
        return variables;
    }

    /**
     * Sets the value of the variables property.
     * 
     * @param value
     *     allowed object is
     *     {@link Variables }
     *     
     */
    public void setVariables(Variables value) {
        this.variables = value;
    }

    /**
     * Gets the value of the rows property.
     * 
     * @return
     *     possible object is
     *     {@link Rows }
     *     
     */
    public Rows getRows() {
        return rows;
    }

    /**
     * Sets the value of the rows property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rows }
     *     
     */
    public void setRows(Rows value) {
        this.rows = value;
    }

    /**
     * Gets the value of the enumTypes property.
     * 
     * @return
     *     possible object is
     *     {@link EnumTypes }
     *     
     */
    public EnumTypes getEnumTypes() {
        return enumTypes;
    }

    /**
     * Sets the value of the enumTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnumTypes }
     *     
     */
    public void setEnumTypes(EnumTypes value) {
        this.enumTypes = value;
    }

    /**
     * Gets the value of the isConcrete property.
     * 
     */
    public boolean isIsConcrete() {
        return isConcrete;
    }

    /**
     * Sets the value of the isConcrete property.
     * 
     */
    public void setIsConcrete(boolean value) {
        this.isConcrete = value;
    }

    /**
     * Gets the value of the isCounterExample property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIsCounterExample() {
        if (isCounterExample == null) {
            return false;
        } else {
            return isCounterExample;
        }
    }

    /**
     * Sets the value of the isCounterExample property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsCounterExample(Boolean value) {
        this.isCounterExample = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        if (name == null) {
            return "Unnamed Specification";
        } else {
            return name;
        }
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
