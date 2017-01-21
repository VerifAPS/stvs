package edu.kit.iti.formal.stvs.model.table;

import edu.kit.iti.formal.stvs.model.common.CodeIoVariable;
import edu.kit.iti.formal.stvs.model.common.FreeVariableSet;
import edu.kit.iti.formal.stvs.model.common.OptionalProperty;
import edu.kit.iti.formal.stvs.model.common.Selection;
import edu.kit.iti.formal.stvs.model.expressions.Type;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

/**
 * @author Benjamin Alt
 */
public class HybridSpecification extends ConstraintSpecification {

  private Optional<ConcreteSpecification> counterExample;
  private OptionalProperty<ConcreteSpecification> concreteInstance;
  private List<Consumer<Optional<ConcreteSpecification>>> concreteInstanceChangedListeners;
  private final boolean editable;

  /**
   * Selection for Spec to Timing-Diagram synchronisation.
   * Should be created <b>once</b> on creation of this class
   */
  private Selection selection;

  public HybridSpecification(Set<Type> typeContext, Set<CodeIoVariable> ioVariables, FreeVariableSet freeVariableSet, boolean editable) {
    super(typeContext, ioVariables, freeVariableSet);
    this.editable = editable;
  }

  public Optional<ConcreteSpecification> getCounterExample() {
    return counterExample;
  }

  public void setCounterExample(ConcreteSpecification counterExample) {
  }

  public Selection getSelection() {
    return selection;
  }

  public List<ConcreteCell> getConcreteValuesForConstraint(String column, int row) {
    return null;
  }

  public ConcreteDuration getDurationForRow(int row) {
    return null;
  }

  public boolean isEditable() {
    return editable;
  }

  public ConcreteSpecification getConcreteInstance() {
    return concreteInstance.get();
  }

  public OptionalProperty<ConcreteSpecification> concreteInstanceProperty() {
    return concreteInstance;
  }

  public void setConcreteInstance(ConcreteSpecification concreteInstance) {
    this.concreteInstance.set(concreteInstance);
  }

  public void removeConcreteInstance() {
    concreteInstance.clear();
  }
}
