package edu.kit.iti.formal.stvs.logic.io.xml;

import edu.kit.iti.formal.stvs.logic.io.ExportException;
import edu.kit.iti.formal.stvs.model.config.GlobalConfig;
import org.w3c.dom.Node;

import javax.xml.bind.JAXBElement;
import java.io.OutputStream;
import java.math.BigInteger;

/**
 * @author Benjamin Alt
 */
public class XmlConfigExporter extends XmlExporter<GlobalConfig> {

  @Override
  public Node exportToXmlNode(GlobalConfig source) throws ExportException {
    ObjectFactory objectFactory = new ObjectFactory();
    Config config = objectFactory.createConfig();
    Config.General general = objectFactory.createConfigGeneral();
    general.setUiLanguage(source.getUiLanguage());
    general.setSimulationTimeout(new BigInteger(Integer.toString(source.getSimulationTimeout())));
    general.setVerificationTimeout(new BigInteger(Integer.toString(source.getVerificationTimeout()
    )));
    Config.General.WindowSize windowSize = objectFactory.createConfigGeneralWindowSize();
    windowSize.setHeight(new BigInteger(Integer.toString(source.getWindowHeight())));
    windowSize.setWidth(new BigInteger(Integer.toString(source.getWindowWidth())));
    general.setWindowSize(windowSize);
    config.setGeneral(general);
    Config.Editor editor = objectFactory.createConfigEditor();
    editor.setFontFamily(source.getEditorFontFamily());
    editor.setFontSize(new BigInteger(Integer.toString(source.getEditorFontSize())));
    editor.setShowLineNumbers(source.getShowLineNumbers());
    config.setEditor(editor);
    JAXBElement<Config> element = objectFactory.createConfig(config);
    return marshalToNode(element);
  }

  public static void main(String[] args) throws ExportException {
    XmlConfigExporter exporter = new XmlConfigExporter();
    OutputStream out = exporter.export(new GlobalConfig());
    System.out.println(out.toString());
  }
}
