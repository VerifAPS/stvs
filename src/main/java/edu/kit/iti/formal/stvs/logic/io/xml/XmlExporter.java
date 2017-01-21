package edu.kit.iti.formal.stvs.logic.io.xml;


import edu.kit.iti.formal.stvs.logic.io.Exporter;
import org.w3c.dom.Node;

/**
 * Created by bal on 11.01.17.
 */
public abstract class XmlExporter<F> implements Exporter<F> {
  public void writeToFile(Node node, String filename) {

  }

  public Node exportToXmlNode(F source) {
    return null;
  }
}