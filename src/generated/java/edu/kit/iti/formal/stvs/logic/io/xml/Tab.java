//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.10 at 04:27:27 PM CET 
//


package edu.kit.iti.formal.stvs.logic.io.xml;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Tab complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Tab">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="specification" type="{http://formal.iti.kit.edu/stvs/logic/io/xml}SpecificationTable" maxOccurs="2"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="open" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="readOnly" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tab", propOrder = {
    "specification"
})
public class Tab {

    @XmlElement(required = true)
    protected List<SpecificationTable> specification;
    @XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger id;
    @XmlAttribute(name = "open", required = true)
    protected boolean open;
    @XmlAttribute(name = "readOnly", required = true)
    protected boolean readOnly;

    /**
     * Gets the value of the specification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpecificationTable }
     * 
     * 
     */
    public List<SpecificationTable> getSpecification() {
        if (specification == null) {
            specification = new ArrayList<SpecificationTable>();
        }
        return this.specification;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

    /**
     * Gets the value of the open property.
     * 
     */
    public boolean isOpen() {
        return open;
    }

    /**
     * Sets the value of the open property.
     * 
     */
    public void setOpen(boolean value) {
        this.open = value;
    }

    /**
     * Gets the value of the readOnly property.
     * 
     */
    public boolean isReadOnly() {
        return readOnly;
    }

    /**
     * Sets the value of the readOnly property.
     * 
     */
    public void setReadOnly(boolean value) {
        this.readOnly = value;
    }

}
