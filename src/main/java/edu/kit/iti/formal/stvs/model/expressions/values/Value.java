package edu.kit.iti.formal.stvs.model.expressions;

/**
 * The common interface for values of Expressions. Values are visitable and have a type.
 *
 * @author Philipp
 */
public interface Value {

  public static interface Visitor<T> {
    T visit(ValueInt value);
    T visit(AbstractValue.ValueSInt value);
    T visit(AbstractValue.ValueDInt value);
    T visit(AbstractValue.ValueLInt value);

    T visit(AbstractValue.ValueUInt value);
    T visit(AbstractValue.ValueUSInt value);
    T visit(AbstractValue.ValueUDInt value);
    T visit(AbstractValue.ValueULInt value);

    T visit(AbstractValue.ValueReal value);
    T visit(AbstractValue.ValueDReal value);


    T visit(ValueBool value);
    T visit(ValueEnum value);
  }

  /**
   * Visitor function for Values. Subclasses call the respective Functions.
   *
   * @param matchInt a function for handling an integer value
   * @param matchBoolean a function for handling a boolean value
   * @param matchEnum a function for handling an enum value
   * @param <R> the return type of the visitor functions
   * @return the return value of the visitor function called
   */
  <T> T accept(Visitor<T> visitor);

  /**
   * Should return type of this value.
   * @return the type for this expression. (returns a TypeBool for a ValueInt for example)
   */
  Type getType();

  /**
   * Should return a string representation of this value.
   * @return a String representation of the represented value
   */
  String getValueString();
}
