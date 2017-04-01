package edu.kit.iti.formal.stvs.model.expressions.types;

import edu.kit.iti.formal.stvs.model.expressions.values.Value;
import edu.kit.iti.formal.stvs.model.expressions.values.ValueInt;

import java.math.BigInteger;
import java.util.Optional;

/**
 * Runtime-representation for int types.
 * This class is a singleton, since it does not hold any state at all.
 *
 * @author Philipp
 */
public class AnyIntType implements Type {
    private final String name;
    protected int bitwidth;
    protected boolean signed;

    public static final AnyIntType INT = new AnyIntType("INT", 16, true);
    public static final AnyIntType SINT = new AnyIntType("SINT", 8, true);
    public static final AnyIntType LINT = new AnyIntType("LINT", 64, true);
    public static final AnyIntType DINT = new AnyIntType("DINT", 32, true);

    public static final AnyIntType UINT = new AnyIntType("UINT", 16, false);
    public static final AnyIntType USINT = new AnyIntType("USINT", 8, false);
    public static final AnyIntType ULINT = new AnyIntType("ULINT", 64, false);
    public static final AnyIntType UDINT = new AnyIntType("UDINT", 32, false);

    public AnyIntType(String name, int bitwidth, boolean signed) {
        this.bitwidth = bitwidth;
        this.signed = signed;
        this.name = name;
    }

    @Override public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override public boolean checksAgainst(Type other) {
        if (other instanceof AnyIntType) {
            AnyIntType oi = (AnyIntType) other;
            if (signed == oi.signed)
                return oi.bitwidth >= bitwidth;
            else if (signed && !oi.signed)
                return oi.bitwidth > bitwidth;
            if (!signed && oi.signed)
                return false;
        }
        return false;
    }

    @Override public String getTypeName() {
        return name;
    }

    @Override public Optional<Value> parseLiteral(String literal) {
        try {
            BigInteger val = new BigInteger(literal);
            ValueInt value = new ValueInt(val);
            return Optional.of(value);
        }
        catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    @Override public Value generateDefaultValue() {
        return new ValueInt(0, INT);
    }

    @Override public String getSMTType() {
        return String.format("(_ BitVec %d)", bitwidth);
    }

    public String toString() {
        return name;
    }

    @Override public boolean equals(Object obj) {
        return obj instanceof AnyIntType;
    }

    public static AnyIntType getSuitableType(BigInteger value) {
        if (value.signum() == 0)
            return INT;
        int bits = Math.max(1, value.bitLength());
        int next2pow = (int) Math.ceil(Math.log(bits) / Math.log(2));
        AnyIntType[] types;
        /*if (value.signum() > 0) {
            types = new AnyIntType[] { USINT, USINT, USINT, USINT, USINT, UINT,
                    UDINT, ULINT };
        }
        else {*/
        types = new AnyIntType[] { SINT, SINT, SINT, SINT, INT, DINT, LINT };
        //}
        return types[next2pow];
    }

    public int getBitwidth() {
        return bitwidth;
    }
}
