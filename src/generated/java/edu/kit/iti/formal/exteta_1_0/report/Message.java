//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.10 at 10:30:34 AM CET 
//


package edu.kit.iti.formal.exteta_1_0.report;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


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
 *         &lt;element name="log" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="entry" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="time" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="level" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="counterexample">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="trace" type="{http://formal.iti.kit.edu/exteta-1.0/report/}counterexample"/>
 *                   &lt;element name="row-mappings" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence maxOccurs="unbounded">
 *                             &lt;element name="row-map" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="returncode">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="error"/>
 *             &lt;enumeration value="counterexample"/>
 *             &lt;enumeration value="verified"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "log",
    "counterexample"
})
@XmlRootElement(name = "message")
public class Message {

    protected Message.Log log;
    @XmlElement(required = true)
    protected Message.Counterexample counterexample;
    @XmlAttribute(name = "returncode")
    protected String returncode;

    /**
     * Gets the value of the log property.
     * 
     * @return
     *     possible object is
     *     {@link Message.Log }
     *     
     */
    public Message.Log getLog() {
        return log;
    }

    /**
     * Sets the value of the log property.
     * 
     * @param value
     *     allowed object is
     *     {@link Message.Log }
     *     
     */
    public void setLog(Message.Log value) {
        this.log = value;
    }

    /**
     * Gets the value of the counterexample property.
     * 
     * @return
     *     possible object is
     *     {@link Message.Counterexample }
     *     
     */
    public Message.Counterexample getCounterexample() {
        return counterexample;
    }

    /**
     * Sets the value of the counterexample property.
     * 
     * @param value
     *     allowed object is
     *     {@link Message.Counterexample }
     *     
     */
    public void setCounterexample(Message.Counterexample value) {
        this.counterexample = value;
    }

    /**
     * Gets the value of the returncode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturncode() {
        return returncode;
    }

    /**
     * Sets the value of the returncode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturncode(String value) {
        this.returncode = value;
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
     *       &lt;all>
     *         &lt;element name="trace" type="{http://formal.iti.kit.edu/exteta-1.0/report/}counterexample"/>
     *         &lt;element name="row-mappings" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence maxOccurs="unbounded">
     *                   &lt;element name="row-map" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/all>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class Counterexample {

        @XmlElement(required = true)
        protected edu.kit.iti.formal.exteta_1_0.report.Counterexample trace;
        @XmlElement(name = "row-mappings")
        protected Message.Counterexample.RowMappings rowMappings;

        /**
         * Gets the value of the trace property.
         * 
         * @return
         *     possible object is
         *     {@link edu.kit.iti.formal.exteta_1_0.report.Counterexample }
         *     
         */
        public edu.kit.iti.formal.exteta_1_0.report.Counterexample getTrace() {
            return trace;
        }

        /**
         * Sets the value of the trace property.
         * 
         * @param value
         *     allowed object is
         *     {@link edu.kit.iti.formal.exteta_1_0.report.Counterexample }
         *     
         */
        public void setTrace(edu.kit.iti.formal.exteta_1_0.report.Counterexample value) {
            this.trace = value;
        }

        /**
         * Gets the value of the rowMappings property.
         * 
         * @return
         *     possible object is
         *     {@link Message.Counterexample.RowMappings }
         *     
         */
        public Message.Counterexample.RowMappings getRowMappings() {
            return rowMappings;
        }

        /**
         * Sets the value of the rowMappings property.
         * 
         * @param value
         *     allowed object is
         *     {@link Message.Counterexample.RowMappings }
         *     
         */
        public void setRowMappings(Message.Counterexample.RowMappings value) {
            this.rowMappings = value;
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
         *       &lt;sequence maxOccurs="unbounded">
         *         &lt;element name="row-map" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "rowMap"
        })
        public static class RowMappings {

            @XmlElement(name = "row-map", required = true)
            protected List<String> rowMap;

            /**
             * Gets the value of the rowMap property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the rowMap property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getRowMap().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getRowMap() {
                if (rowMap == null) {
                    rowMap = new ArrayList<String>();
                }
                return this.rowMap;
            }

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
     *       &lt;sequence>
     *         &lt;element name="entry" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="time" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="level" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
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
    @XmlType(name = "", propOrder = {
        "entry"
    })
    public static class Log {

        protected List<Message.Log.Entry> entry;

        /**
         * Gets the value of the entry property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the entry property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEntry().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Message.Log.Entry }
         * 
         * 
         */
        public List<Message.Log.Entry> getEntry() {
            if (entry == null) {
                entry = new ArrayList<Message.Log.Entry>();
            }
            return this.entry;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="time" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="level" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Entry {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "time")
            protected Integer time;
            @XmlAttribute(name = "level")
            protected String level;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the time property.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getTime() {
                return time;
            }

            /**
             * Sets the value of the time property.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setTime(Integer value) {
                this.time = value;
            }

            /**
             * Gets the value of the level property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLevel() {
                return level;
            }

            /**
             * Sets the value of the level property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLevel(String value) {
                this.level = value;
            }

        }

    }

}
