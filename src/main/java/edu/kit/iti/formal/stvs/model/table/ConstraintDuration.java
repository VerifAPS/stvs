package edu.kit.iti.formal.stvs.model.table;

import edu.kit.iti.formal.stvs.model.expressions.LowerBoundedInterval;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Benjamin Alt
 */
public class ConstraintDuration implements CellOperationProvider {

  private StringProperty stringRepresentation;
  private StringProperty comment;
  private ObjectProperty<LowerBoundedInterval> lowerBoundedInterval;

  public ConstraintDuration(String stringRepresentation) {
    this.comment = new SimpleStringProperty();
    this.stringRepresentation = new SimpleStringProperty(stringRepresentation);
    this.lowerBoundedInterval = new SimpleObjectProperty<>();
  }

  @Override
  public String getAsString() {
    return this.stringRepresentation.get();
  }

  @Override
  public void setFromString(String stringRepresentation) {
    this.stringRepresentation.set(stringRepresentation);
  }

  @Override
  public StringProperty stringRepresentationProperty() {
    return stringRepresentation;
  }

  public ObjectProperty<LowerBoundedInterval> lowerBoundedIntervalProperty() {
    return lowerBoundedInterval;
  }

  @Override
  public void setComment(String comment) {
    this.comment.set(comment);
  }

  @Override
  public String getComment() {
    return comment.get();
  }

  @Override
  public StringProperty commentProperty() {
    return comment;
  }
}
