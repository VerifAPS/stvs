package edu.kit.iti.formal.stvs.logic.io.verification;

import edu.kit.iti.formal.stvs.logic.io.Exporter;
import edu.kit.iti.formal.stvs.logic.io.xml.XmlSpecExporter;
import edu.kit.iti.formal.stvs.model.table.ConstraintSpecification;

import java.io.ByteArrayOutputStream;

/**
 * Created by bal on 09.01.17.
 */
public class VerificationExporter implements Exporter<ConstraintSpecification> {

  private XmlSpecExporter xmlExporter;

  public VerificationExporter() {

  }

  public ByteArrayOutputStream export(ConstraintSpecification source) {
    return null;
  }
}
