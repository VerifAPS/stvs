//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7-b41 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.02.19 um 01:09:35 PM CET 
//


package edu.kit.iti.formal.exteta_1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r steps complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="steps">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;choice>
 *           &lt;element name="block" type="{http://formal.iti.kit.edu/exteta-1.0}block"/>
 *           &lt;element name="step" type="{http://formal.iti.kit.edu/exteta-1.0}step"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "steps", propOrder = {
    "blockOrStep"
})
public class Steps {

    @XmlElements({
        @XmlElement(name = "block", type = Block.class),
        @XmlElement(name = "step", type = Step.class)
    })
    protected List<Object> blockOrStep;

    /**
     * Gets the value of the blockOrStep property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the blockOrStep property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBlockOrStep().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Block }
     * {@link Step }
     * 
     * 
     */
    public List<Object> getBlockOrStep() {
        if (blockOrStep == null) {
            blockOrStep = new ArrayList<Object>();
        }
        return this.blockOrStep;
    }

}
