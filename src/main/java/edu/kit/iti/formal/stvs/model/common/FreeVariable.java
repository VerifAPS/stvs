package edu.kit.iti.formal.stvs.model.common;

import edu.kit.iti.formal.stvs.model.expressions.Type;
import edu.kit.iti.formal.stvs.model.expressions.Value;
import javafx.beans.property.*;
import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * Created by csicar on 10.01.17.
 */
public class FreeVariable implements Variable {
  private final StringProperty name;
  private final ObjectProperty<Type> type;
  private final NullableProperty<Value> defaultValue;

  /**
   * Creates a free variable with a name and type.
   * A default value will be generated through {@link Type#generateDefaultValue()}.
   *
   * @param name Name of the free variable
   * @param type Type of the free variable
   */
  public FreeVariable(String name, Type type) {
    this.name = new SimpleStringProperty(name);
    this.type = new SimpleObjectProperty<>(type);
    this.defaultValue = new NullableProperty<>();
  }

  /**
   * Creates a free variable with a name, type and default value.
   *
   * @param name         Name of the free variable
   * @param type         Type of the free variable
   * @param defaultValue Default value of the free variable
   * @throws IllegalValueTypeException thrown if {@link Type}
   *                                   of {@code defaultValue} does not match {@code type}
   */
  public FreeVariable(String name, Type type, Value defaultValue) throws IllegalValueTypeException {
    this.name = new SimpleStringProperty(name);
    this.type = new SimpleObjectProperty<>(type);
    if (!defaultValue.getType().checksAgainst(type)) {
      throw new IllegalValueTypeException(defaultValue, type, "DefaultValue has wrong type.");
    }
    this.defaultValue = new NullableProperty<>(defaultValue);
  }

  public String getName() {
    return name.get();
  }

  public StringProperty nameProperty() {
    return name;
  }

  /**
   * Rename the variable.
   *
   * @param name New name for the free variable
   */
  public void setName(String name) {
    if (!freevarNameValid(name)) {
      throw new IllegalArgumentException("Free Variable name is not valid: " + name);
    }
    this.name.set(name);
  }

  private boolean freevarNameValid(String name) {
    if (name.isEmpty()) {
      return false;
    }
    if (!Character.isJavaIdentifierStart(name.charAt(0))) {
      return false;
    }
    for (int i = 1; i < name.length(); i++) {
      if (!Character.isJavaIdentifierPart(name.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  public Type getType() {
    return type.get();
  }

  public ReadOnlyObjectProperty<Type> typeProperty() {
    return type;
  }

  /**
   * Sets the type of this variable.
   * If the current default value has a different type, it is cleared.
   *
   * @param type New type for the free variable
   */
  public void setType(Type type) {
    this.type.set(type);
    if (this.defaultValue.get() != null && !this.defaultValue.get().getType().checksAgainst(type)) {
      this.defaultValue.set(null);
    }
  }

  public Value getDefaultValue() {
    return defaultValue.get();
  }

  public ReadOnlyObjectProperty<Value> defaultValueProperty() {
    return defaultValue;
  }

  /**
   * Assigns a new value to the free variable.
   *
   * @param defaultValue New default value for the free variable
   * @throws IllegalValueTypeException thrown if {@link Type}
   *                                   of {@code defaultValue} does not match {@code type}
   */
  public void setDefaultValue(Value defaultValue) throws IllegalValueTypeException {
    if (defaultValue != null && !defaultValue.getType().checksAgainst(this.type.get())) {
      throw new IllegalValueTypeException(defaultValue, this.type.get(), "Illegal Type:");
    }
    this.defaultValue.set(defaultValue);
  }

  @Override
  public String toString() {
    return "FreeVariable{"
        + "name=" + name.get()
        + ", type=" + type.get()
        + ", defaultValue=" + defaultValue.get()
        + '}';
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof FreeVariable)) return false;
    if (obj == this) return true;

    FreeVariable rhs = (FreeVariable) obj;
    return new EqualsBuilder().
            append(name.get(), rhs.name.get()).
            append(type.get(), rhs.type.get()).
            append(defaultValue.get(), rhs.defaultValue.get()).
            isEquals();
  }
}
