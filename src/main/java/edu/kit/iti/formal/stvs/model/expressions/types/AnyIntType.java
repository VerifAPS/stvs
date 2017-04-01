package edu.kit.iti.formal.stvs.model.expressions.types;

import edu.kit.iti.formal.stvs.model.expressions.values.Value;
import edu.kit.iti.formal.stvs.model.expressions.values.ValueInt;

import java.util.Optional;

/**
 * Runtime-representation for int types.
 * This class is a singleton, since it does not hold any state at all.
 *
 * @author Philipp
 */
public class TypeInt implements Type {
    protected int bitwidth;
    protected boolean signed;

    public static final TypeInt INT = new TypeInt(16, true);
    public static final TypeInt SINT = new TypeInt(8, true);
    public static final TypeInt LINT = new TypeInt(64, true);
    public static final TypeInt DINT = new TypeInt(32, true);

    public static final TypeInt UINT = new TypeInt(16, false);
    public static final TypeInt USINT = new TypeInt(8, false);
    public static final TypeInt ULINT = new TypeInt(64, false);
    public static final TypeInt UDINT = new TypeInt(32, false);

    public TypeInt(int bitwidth, boolean signed) {
        this.bitwidth = bitwidth;
        this.signed = signed;
    }

    @Override public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override public boolean checksAgainst(Type other) {
        if (other instanceof TypeInt) {
            TypeInt typeInt = (TypeInt) other;
            if (signed == typeInt.signed)
                return typeInt.bitwidth >= bitwidth;
            else if (signed && !typeInt.signed)
                return typeInt.bitwidth > bitwidth;
            if (!signed && typeInt.signed)
                return false;
        }
        else
            return false;
    }

    @Override public String getTypeName() {
        return "INT";
    }

    @Override public Optional<Value> parseLiteral(String literal) {
        try {
            return Optional.of(new ValueInt(Integer.parseInt(literal)));
        }
        catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    @Override public Value generateDefaultValue() {
        return new ValueInt(1);
    }

    public String toString() {
        return "TypeInt";
    }

    @Override public boolean equals(Object obj) {
        return obj instanceof TypeInt;
    }
}
