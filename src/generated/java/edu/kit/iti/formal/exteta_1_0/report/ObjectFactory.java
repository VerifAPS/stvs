//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.03 at 07:20:08 PM CET 
//


package edu.kit.iti.formal.exteta_1_0.report;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.kit.iti.formal.exteta_1_0.report package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.kit.iti.formal.exteta_1_0.report
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Counterexample }
     * 
     */
    public Counterexample createCounterexample() {
        return new Counterexample();
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link Message.Log }
     * 
     */
    public Message.Log createMessageLog() {
        return new Message.Log();
    }

    /**
     * Create an instance of {@link Counterexample.Step }
     * 
     */
    public Counterexample.Step createCounterexampleStep() {
        return new Counterexample.Step();
    }

    /**
     * Create an instance of {@link Assignment }
     * 
     */
    public Assignment createAssignment() {
        return new Assignment();
    }

    /**
     * Create an instance of {@link Message.Log.Entry }
     * 
     */
    public Message.Log.Entry createMessageLogEntry() {
        return new Message.Log.Entry();
    }

}
