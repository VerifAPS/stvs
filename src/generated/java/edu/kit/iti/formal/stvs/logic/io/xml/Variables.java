//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.15 at 04:23:13 PM CET 
//


package edu.kit.iti.formal.stvs.logic.io.xml;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Variables complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Variables">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ioVariable" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="io" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="data-type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="colwidth" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *                 &lt;attribute name="comment" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="freeVariable" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="data-type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="default" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Variables", propOrder = {
    "ioVariable",
    "freeVariable"
})
public class Variables {

    protected List<Variables.IoVariable> ioVariable;
    protected List<Variables.FreeVariable> freeVariable;

    /**
     * Gets the value of the ioVariable property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ioVariable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIoVariable().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Variables.IoVariable }
     * 
     * 
     */
    public List<Variables.IoVariable> getIoVariable() {
        if (ioVariable == null) {
            ioVariable = new ArrayList<Variables.IoVariable>();
        }
        return this.ioVariable;
    }

    /**
     * Gets the value of the freeVariable property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the freeVariable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFreeVariable().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Variables.FreeVariable }
     * 
     * 
     */
    public List<Variables.FreeVariable> getFreeVariable() {
        if (freeVariable == null) {
            freeVariable = new ArrayList<Variables.FreeVariable>();
        }
        return this.freeVariable;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="data-type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="default" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class FreeVariable {

        @XmlAttribute(name = "name", required = true)
        protected String name;
        @XmlAttribute(name = "data-type", required = true)
        protected String dataType;
        @XmlAttribute(name = "default")
        protected String _default;

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
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

        /**
         * Gets the value of the dataType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDataType() {
            return dataType;
        }

        /**
         * Sets the value of the dataType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDataType(String value) {
            this.dataType = value;
        }

        /**
         * Gets the value of the default property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDefault() {
            return _default;
        }

        /**
         * Sets the value of the default property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDefault(String value) {
            this._default = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="io" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="data-type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="colwidth" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *       &lt;attribute name="comment" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class IoVariable {

        @XmlAttribute(name = "io", required = true)
        protected String io;
        @XmlAttribute(name = "name", required = true)
        protected String name;
        @XmlAttribute(name = "data-type", required = true)
        protected String dataType;
        @XmlAttribute(name = "colwidth")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger colwidth;
        @XmlAttribute(name = "comment")
        protected String comment;

        /**
         * Gets the value of the io property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIo() {
            return io;
        }

        /**
         * Sets the value of the io property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIo(String value) {
            this.io = value;
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
            return name;
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

        /**
         * Gets the value of the dataType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDataType() {
            return dataType;
        }

        /**
         * Sets the value of the dataType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDataType(String value) {
            this.dataType = value;
        }

        /**
         * Gets the value of the colwidth property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getColwidth() {
            return colwidth;
        }

        /**
         * Sets the value of the colwidth property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setColwidth(BigInteger value) {
            this.colwidth = value;
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

    }

}
