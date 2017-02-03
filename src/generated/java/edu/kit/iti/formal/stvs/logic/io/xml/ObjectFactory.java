//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.03 at 12:36:15 AM CET 
//


package edu.kit.iti.formal.stvs.logic.io.xml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.kit.iti.formal.stvs.logic.io.xml package. 
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

    private final static QName _Specification_QNAME = new QName("http://formal.iti.kit.edu/stvs/logic/io/xml", "specification");
    private final static QName _Config_QNAME = new QName("http://formal.iti.kit.edu/stvs/logic/io/xml", "config");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.kit.iti.formal.stvs.logic.io.xml
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Session }
     * 
     */
    public Session createSession() {
        return new Session();
    }

    /**
     * Create an instance of {@link DisplayInfo }
     * 
     */
    public DisplayInfo createDisplayInfo() {
        return new DisplayInfo();
    }

    /**
     * Create an instance of {@link DisplayInfo.IoVariables }
     * 
     */
    public DisplayInfo.IoVariables createDisplayInfoIoVariables() {
        return new DisplayInfo.IoVariables();
    }

    /**
     * Create an instance of {@link AdditionalInfo }
     * 
     */
    public AdditionalInfo createAdditionalInfo() {
        return new AdditionalInfo();
    }

    /**
     * Create an instance of {@link AdditionalInfo.Enums }
     * 
     */
    public AdditionalInfo.Enums createAdditionalInfoEnums() {
        return new AdditionalInfo.Enums();
    }

    /**
     * Create an instance of {@link AdditionalInfo.Rows }
     * 
     */
    public AdditionalInfo.Rows createAdditionalInfoRows() {
        return new AdditionalInfo.Rows();
    }

    /**
     * Create an instance of {@link AdditionalInfo.Rows.Row }
     * 
     */
    public AdditionalInfo.Rows.Row createAdditionalInfoRowsRow() {
        return new AdditionalInfo.Rows.Row();
    }

    /**
     * Create an instance of {@link AdditionalInfo.IoVariables }
     * 
     */
    public AdditionalInfo.IoVariables createAdditionalInfoIoVariables() {
        return new AdditionalInfo.IoVariables();
    }

    /**
     * Create an instance of {@link AdditionalInfo.ConstraintVariables }
     * 
     */
    public AdditionalInfo.ConstraintVariables createAdditionalInfoConstraintVariables() {
        return new AdditionalInfo.ConstraintVariables();
    }

    /**
     * Create an instance of {@link Config }
     * 
     */
    public Config createConfig() {
        return new Config();
    }

    /**
     * Create an instance of {@link Config.General }
     * 
     */
    public Config.General createConfigGeneral() {
        return new Config.General();
    }

    /**
     * Create an instance of {@link Code }
     * 
     */
    public Code createCode() {
        return new Code();
    }

    /**
     * Create an instance of {@link Session.Tabs }
     * 
     */
    public Session.Tabs createSessionTabs() {
        return new Session.Tabs();
    }

    /**
     * Create an instance of {@link History }
     * 
     */
    public History createHistory() {
        return new History();
    }

    /**
     * Create an instance of {@link SpecificationTable }
     * 
     */
    public SpecificationTable createSpecificationTable() {
        return new SpecificationTable();
    }

    /**
     * Create an instance of {@link Project }
     * 
     */
    public Project createProject() {
        return new Project();
    }

    /**
     * Create an instance of {@link Tab }
     * 
     */
    public Tab createTab() {
        return new Tab();
    }

    /**
     * Create an instance of {@link DisplayInfo.IoVariables.VariableIdentifier }
     * 
     */
    public DisplayInfo.IoVariables.VariableIdentifier createDisplayInfoIoVariablesVariableIdentifier() {
        return new DisplayInfo.IoVariables.VariableIdentifier();
    }

    /**
     * Create an instance of {@link AdditionalInfo.Table }
     * 
     */
    public AdditionalInfo.Table createAdditionalInfoTable() {
        return new AdditionalInfo.Table();
    }

    /**
     * Create an instance of {@link AdditionalInfo.Enums.Enum }
     * 
     */
    public AdditionalInfo.Enums.Enum createAdditionalInfoEnumsEnum() {
        return new AdditionalInfo.Enums.Enum();
    }

    /**
     * Create an instance of {@link AdditionalInfo.Rows.Row.VariableIdentifier }
     * 
     */
    public AdditionalInfo.Rows.Row.VariableIdentifier createAdditionalInfoRowsRowVariableIdentifier() {
        return new AdditionalInfo.Rows.Row.VariableIdentifier();
    }

    /**
     * Create an instance of {@link AdditionalInfo.IoVariables.VariableIdentifier }
     * 
     */
    public AdditionalInfo.IoVariables.VariableIdentifier createAdditionalInfoIoVariablesVariableIdentifier() {
        return new AdditionalInfo.IoVariables.VariableIdentifier();
    }

    /**
     * Create an instance of {@link AdditionalInfo.ConstraintVariables.ConstraintVariable }
     * 
     */
    public AdditionalInfo.ConstraintVariables.ConstraintVariable createAdditionalInfoConstraintVariablesConstraintVariable() {
        return new AdditionalInfo.ConstraintVariables.ConstraintVariable();
    }

    /**
     * Create an instance of {@link Config.Editor }
     * 
     */
    public Config.Editor createConfigEditor() {
        return new Config.Editor();
    }

    /**
     * Create an instance of {@link Config.General.WindowSize }
     * 
     */
    public Config.General.WindowSize createConfigGeneralWindowSize() {
        return new Config.General.WindowSize();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SpecificationTable }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://formal.iti.kit.edu/stvs/logic/io/xml", name = "specification")
    public JAXBElement<SpecificationTable> createSpecification(SpecificationTable value) {
        return new JAXBElement<SpecificationTable>(_Specification_QNAME, SpecificationTable.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Config }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://formal.iti.kit.edu/stvs/logic/io/xml", name = "config")
    public JAXBElement<Config> createConfig(Config value) {
        return new JAXBElement<Config>(_Config_QNAME, Config.class, null, value);
    }

}
