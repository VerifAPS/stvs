//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.10 at 04:27:27 PM CET 
//


package edu.kit.iti.formal.stvs.logic.io.xml;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Config complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Config">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="general" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="uiLanguage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="windowSize" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *                             &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="verificationTimeout" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *                   &lt;element name="simulationTimeout" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *                   &lt;element name="maxLineRollout" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="editor" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="showLineNumbers" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                   &lt;element name="fontFamily" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="fontSize" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="dependencies" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="javaPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="z3Path" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="getetaPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="nuxmvPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
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
@XmlType(name = "Config", propOrder = {
    "general",
    "editor",
    "dependencies"
})
public class Config {

    protected Config.General general;
    protected Config.Editor editor;
    protected Config.Dependencies dependencies;

    /**
     * Gets the value of the general property.
     * 
     * @return
     *     possible object is
     *     {@link Config.General }
     *     
     */
    public Config.General getGeneral() {
        return general;
    }

    /**
     * Sets the value of the general property.
     * 
     * @param value
     *     allowed object is
     *     {@link Config.General }
     *     
     */
    public void setGeneral(Config.General value) {
        this.general = value;
    }

    /**
     * Gets the value of the editor property.
     * 
     * @return
     *     possible object is
     *     {@link Config.Editor }
     *     
     */
    public Config.Editor getEditor() {
        return editor;
    }

    /**
     * Sets the value of the editor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Config.Editor }
     *     
     */
    public void setEditor(Config.Editor value) {
        this.editor = value;
    }

    /**
     * Gets the value of the dependencies property.
     * 
     * @return
     *     possible object is
     *     {@link Config.Dependencies }
     *     
     */
    public Config.Dependencies getDependencies() {
        return dependencies;
    }

    /**
     * Sets the value of the dependencies property.
     * 
     * @param value
     *     allowed object is
     *     {@link Config.Dependencies }
     *     
     */
    public void setDependencies(Config.Dependencies value) {
        this.dependencies = value;
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
     *         &lt;element name="javaPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="z3Path" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="getetaPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="nuxmvPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "javaPath",
        "z3Path",
        "getetaPath",
        "nuxmvPath"
    })
    public static class Dependencies {

        protected String javaPath;
        protected String z3Path;
        protected String getetaPath;
        protected String nuxmvPath;

        /**
         * Gets the value of the javaPath property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJavaPath() {
            return javaPath;
        }

        /**
         * Sets the value of the javaPath property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJavaPath(String value) {
            this.javaPath = value;
        }

        /**
         * Gets the value of the z3Path property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getZ3Path() {
            return z3Path;
        }

        /**
         * Sets the value of the z3Path property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setZ3Path(String value) {
            this.z3Path = value;
        }

        /**
         * Gets the value of the getetaPath property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGetetaPath() {
            return getetaPath;
        }

        /**
         * Sets the value of the getetaPath property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGetetaPath(String value) {
            this.getetaPath = value;
        }

        /**
         * Gets the value of the nuxmvPath property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNuxmvPath() {
            return nuxmvPath;
        }

        /**
         * Sets the value of the nuxmvPath property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNuxmvPath(String value) {
            this.nuxmvPath = value;
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
     *         &lt;element name="showLineNumbers" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *         &lt;element name="fontFamily" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="fontSize" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
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
        "showLineNumbers",
        "fontFamily",
        "fontSize"
    })
    public static class Editor {

        @XmlElement(defaultValue = "true")
        protected Boolean showLineNumbers;
        protected String fontFamily;
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger fontSize;

        /**
         * Gets the value of the showLineNumbers property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isShowLineNumbers() {
            return showLineNumbers;
        }

        /**
         * Sets the value of the showLineNumbers property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setShowLineNumbers(Boolean value) {
            this.showLineNumbers = value;
        }

        /**
         * Gets the value of the fontFamily property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFontFamily() {
            return fontFamily;
        }

        /**
         * Sets the value of the fontFamily property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFontFamily(String value) {
            this.fontFamily = value;
        }

        /**
         * Gets the value of the fontSize property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getFontSize() {
            return fontSize;
        }

        /**
         * Sets the value of the fontSize property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setFontSize(BigInteger value) {
            this.fontSize = value;
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
     *         &lt;element name="uiLanguage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="windowSize" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
     *                   &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="verificationTimeout" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
     *         &lt;element name="simulationTimeout" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
     *         &lt;element name="maxLineRollout" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
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
        "uiLanguage",
        "windowSize",
        "verificationTimeout",
        "simulationTimeout",
        "maxLineRollout"
    })
    public static class General {

        protected String uiLanguage;
        protected Config.General.WindowSize windowSize;
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger verificationTimeout;
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger simulationTimeout;
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger maxLineRollout;

        /**
         * Gets the value of the uiLanguage property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUiLanguage() {
            return uiLanguage;
        }

        /**
         * Sets the value of the uiLanguage property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUiLanguage(String value) {
            this.uiLanguage = value;
        }

        /**
         * Gets the value of the windowSize property.
         * 
         * @return
         *     possible object is
         *     {@link Config.General.WindowSize }
         *     
         */
        public Config.General.WindowSize getWindowSize() {
            return windowSize;
        }

        /**
         * Sets the value of the windowSize property.
         * 
         * @param value
         *     allowed object is
         *     {@link Config.General.WindowSize }
         *     
         */
        public void setWindowSize(Config.General.WindowSize value) {
            this.windowSize = value;
        }

        /**
         * Gets the value of the verificationTimeout property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getVerificationTimeout() {
            return verificationTimeout;
        }

        /**
         * Sets the value of the verificationTimeout property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setVerificationTimeout(BigInteger value) {
            this.verificationTimeout = value;
        }

        /**
         * Gets the value of the simulationTimeout property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getSimulationTimeout() {
            return simulationTimeout;
        }

        /**
         * Sets the value of the simulationTimeout property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setSimulationTimeout(BigInteger value) {
            this.simulationTimeout = value;
        }

        /**
         * Gets the value of the maxLineRollout property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getMaxLineRollout() {
            return maxLineRollout;
        }

        /**
         * Sets the value of the maxLineRollout property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setMaxLineRollout(BigInteger value) {
            this.maxLineRollout = value;
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
         *         &lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
         *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
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
            "width",
            "height"
        })
        public static class WindowSize {

            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger width;
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger height;

            /**
             * Gets the value of the width property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getWidth() {
                return width;
            }

            /**
             * Sets the value of the width property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setWidth(BigInteger value) {
                this.width = value;
            }

            /**
             * Gets the value of the height property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getHeight() {
                return height;
            }

            /**
             * Sets the value of the height property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setHeight(BigInteger value) {
                this.height = value;
            }

        }

    }

}
