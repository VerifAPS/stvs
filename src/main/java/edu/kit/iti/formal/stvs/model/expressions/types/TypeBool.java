package edu.kit.iti.formal.stvs.model.expressions.types;

import edu.kit.iti.formal.stvs.model.expressions.values.Value;
import edu.kit.iti.formal.stvs.model.expressions.values.ValueBool;

import java.util.Optional;

/**
 * Runtime-representation for boolean types.
 * This is a singleton since this class does not have any state.
 *
 * @author Philipp
 */
public class TypeBool implements Type {

  public static final TypeBool BOOL = new TypeBool();

  private TypeBool() {}

  @Override public <R> R accept(TypeVisitor<R> visitor) {
    return visitor.visit(this);
  }

  @Override
  public boolean checksAgainst(Type other) {
    return equals(other);
  }

  @Override
  public String getTypeName() {
    return "BOOL";
  }

  @Override
  public Optional<Value> parseLiteral(String literal) {
    if ("true".equalsIgnoreCase(literal)) {
      return Optional.of(ValueBool.TRUE);
    }
    if ("false".equalsIgnoreCase(literal)) {
      return Optional.of(ValueBool.FALSE);
    }
    return Optional.empty();
  }

  @Override
  public Value generateDefaultValue() {
    return ValueBool.FALSE;
  }

  @Override public String getSMTType() {
    return "Bool";
  }

  public String toString() {
    return "TypeBool";
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof TypeBool;
  }
}
