package edu.kit.iti.formal.stvs.model.expressions;

import java.util.function.Function;
import java.util.function.IntFunction;

/**
 * runtime-representation for enum values of {@link Expression}s.
 *
 * <p>In contrast to {@link ValueBool} this is not a singleton, since
 * many different instances can be created at runtime.
 * getType of this value always returns a {@link TypeEnum}.
 */
public class ValueEnum implements Value {

  private final String enumValue;
  private final TypeEnum enumType;

  /**
   * Construct a new value of given type with given constructor.
   * @param enumValue enum constructor (for example <tt>red</tt>)
   * @param enumType enum type (for example <tt>TypeEnum(COLORS, [red, green, blue])</tt>)
   * @throws IllegalArgumentException when the given enumValue is not existant in the enum type
   *                                  (for example <tt>purple</tt>)
   */
  public ValueEnum(String enumValue, TypeEnum enumType) {
    this.enumValue = enumValue;
    this.enumType = enumType;
    if (!enumType.getValues().contains(enumValue)) {
      throw new IllegalArgumentException("new ValueEnum: the type does not contain the given constructor!");
    }
  }

  @Override
  public <R> R match(
      IntFunction<R> matchInt,
      Function<Boolean, R> matchBoolean,
      Function<ValueEnum, R> matchEnum) {
    return null;
  }

  public boolean equals(ValueEnum other) {
    return other != null && enumValue.equals(other.enumValue) && enumType.equals(other.enumType);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof ValueEnum)) return false;

    ValueEnum valueEnum = (ValueEnum) obj;

    if (!enumValue.equals(valueEnum.enumValue)) return false;
    return enumType.equals(valueEnum.enumType);

  }

  @Override
  public int hashCode() {
    int result = enumValue.hashCode();
    result = 31 * result + enumType.hashCode();
    return result;
  }

  @Override
  public Type getType() {
    return enumType;
  }

  public String getEnumValue() {
    return enumValue;
  }

  public String toString() {
    return "ValueEnum(" + enumValue + ")";
  }

}
