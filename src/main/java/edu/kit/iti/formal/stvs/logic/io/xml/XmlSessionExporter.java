package edu.kit.iti.formal.stvs.logic.io.xml;

import edu.kit.iti.formal.stvs.model.StvsRootModel;
import org.w3c.dom.Node;

/**
 * @author Benjamin Alt
 */
public class XmlSessionExporter extends XmlExporter<StvsRootModel> {
  private XmlConfigExporter configExporter;
  private XmlSpecExporter specExporter;

  @Override
  public Node exportToXmlNode(StvsRootModel source) {

    return null;
  }
}
