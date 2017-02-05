//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.03 at 07:20:08 PM CET 
//


package edu.kit.iti.formal.exteta_1_0.report;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="step">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;sequence>
 *                     &lt;choice>
 *                       &lt;element name="input" type="{http://formal.iti.kit.edu/exteta-1.0/report/}assignment" maxOccurs="unbounded" minOccurs="0"/>
 *                       &lt;element name="state" type="{http://formal.iti.kit.edu/exteta-1.0/report/}assignment" maxOccurs="unbounded" minOccurs="0"/>
 *                     &lt;/choice>
 *                   &lt;/sequence>
 *                 &lt;/sequence>
 *                 &lt;attribute name="counter" type="{http://www.w3.org/2001/XMLSchema}int" />
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
@XmlType(name = "", propOrder = {
    "step"
})
@XmlRootElement(name = "counterexample")
public class Counterexample {

    protected List<Counterexample.Step> step;

    /**
     * Gets the value of the step property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the step property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStep().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Counterexample.Step }
     * 
     * 
     */
    public List<Counterexample.Step> getStep() {
        if (step == null) {
            step = new ArrayList<Counterexample.Step>();
        }
        return this.step;
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
     *         &lt;sequence>
     *           &lt;choice>
     *             &lt;element name="input" type="{http://formal.iti.kit.edu/exteta-1.0/report/}assignment" maxOccurs="unbounded" minOccurs="0"/>
     *             &lt;element name="state" type="{http://formal.iti.kit.edu/exteta-1.0/report/}assignment" maxOccurs="unbounded" minOccurs="0"/>
     *           &lt;/choice>
     *         &lt;/sequence>
     *       &lt;/sequence>
     *       &lt;attribute name="counter" type="{http://www.w3.org/2001/XMLSchema}int" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "input",
        "state"
    })
    public static class Step {

        protected List<Assignment> input;
        protected List<Assignment> state;
        @XmlAttribute(name = "counter")
        protected Integer counter;

        /**
         * Gets the value of the input property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the input property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInput().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Assignment }
         * 
         * 
         */
        public List<Assignment> getInput() {
            if (input == null) {
                input = new ArrayList<Assignment>();
            }
            return this.input;
        }

        /**
         * Gets the value of the state property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the state property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getState().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Assignment }
         * 
         * 
         */
        public List<Assignment> getState() {
            if (state == null) {
                state = new ArrayList<Assignment>();
            }
            return this.state;
        }

        /**
         * Gets the value of the counter property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getCounter() {
            return counter;
        }

        /**
         * Sets the value of the counter property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setCounter(Integer value) {
            this.counter = value;
        }

    }

}
