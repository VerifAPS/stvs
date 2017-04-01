package edu.kit.iti.formal.stvs.model.expressions.types;

/**
 * @author Alexander Weigl
 * @version 1 (31.03.17)
 */
public interface TypeVisitor<T> {
    T visit(AnyIntType type);

    T visit(TypeEnum typeEnum);

    T visit(TypeBool typeBool);
}
