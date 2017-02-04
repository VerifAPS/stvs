package edu.kit.iti.formal.stvs.model.table;

import edu.kit.iti.formal.stvs.model.common.FreeVariableSet;
import edu.kit.iti.formal.stvs.model.expressions.Expression;
import edu.kit.iti.formal.stvs.model.expressions.LowerBoundedInterval;
import edu.kit.iti.formal.stvs.model.expressions.Type;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Benjamin Alt
 */
public class ValidSpecification extends SpecificationTable<Expression, LowerBoundedInterval> {

  private final ObservableSet<Type> typeContext;
  private FreeVariableSet freeVariableSet;

  public ValidSpecification(ObservableSet<Type> typeContext, FreeVariableSet freeVariableSet) {
    super();
    this.typeContext = typeContext;
    this.freeVariableSet = freeVariableSet;
  }
}
