//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
<<<<<<< HEAD
// Generated on: 2017.02.10 at 10:30:34 AM CET 
=======
// Generated on: 2017.02.08 at 03:43:11 PM CET 
>>>>>>> ad48c3473ce485b294948af61e39552b8a4fea8f
//


package edu.kit.iti.formal.exteta_1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for block complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="block">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;choice>
 *           &lt;element name="step" type="{http://formal.iti.kit.edu/exteta-1.0}step"/>
 *           &lt;element name="block" type="{http://formal.iti.kit.edu/exteta-1.0}block"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="duration" type="{http://formal.iti.kit.edu/exteta-1.0}duration" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "block", propOrder = {
    "stepOrBlock"
})
public class Block {

    @XmlElements({
        @XmlElement(name = "step", type = Step.class),
        @XmlElement(name = "block", type = Block.class)
    })
    protected List<Object> stepOrBlock;
    @XmlAttribute(name = "duration")
    protected String duration;

    /**
     * Gets the value of the stepOrBlock property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stepOrBlock property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStepOrBlock().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Step }
     * {@link Block }
     * 
     * 
     */
    public List<Object> getStepOrBlock() {
        if (stepOrBlock == null) {
            stepOrBlock = new ArrayList<Object>();
        }
        return this.stepOrBlock;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDuration(String value) {
        this.duration = value;
    }

}
