package edu.kit.iti.formal.stvs.model.table;

import javafx.beans.property.StringProperty;

/**
 * @author Benjamin Alt
 */
public interface StringEditable {

  String getAsString();

  void setFromString(String input);

  StringProperty stringRepresentationProperty();
}
