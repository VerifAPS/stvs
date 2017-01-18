package edu.kit.iti.formal.stvs.model.expressions;

import java.util.List;
import java.util.Map;

import static edu.kit.iti.formal.stvs.model.expressions.FunctionExpr.Operation.*;

public class TypeChecker implements ExpressionVisitor<Type> {

    private static class InternalTypeCheckException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        private final Expression mistypedExpression;

        public InternalTypeCheckException(Expression mistypedExpression, String message) {
            super(message);
            this.mistypedExpression = mistypedExpression;
        }

        public Expression getMistypedExpression() {
            return mistypedExpression;
        }

    }

    private final Map<String, Type> variableTypeContext;

    public TypeChecker(Map<String, Type> variableTypeContext) {
        this.variableTypeContext = variableTypeContext;
    }

    public Type typeCheck(Expression expr) throws TypeCheckException {
        try {
            return expr.takeVisitor(this);
        } catch (InternalTypeCheckException e) {
            throw new TypeCheckException(
                    e.getMistypedExpression(),
                    e.getMessage());
        }
    }

    @Override
    public Type visitFunctionExpr(FunctionExpr functionExpr) {
        switch (functionExpr.getOperation()) {
            // BOOL -> BOOL
            case NOT:
                ensureArgsOfType(functionExpr, TypeBool.BOOL);
            // (INT, INT) -> INT
            case PLUS:
            case MINUS:
            case MULTIPLICATION:
            case DIVISION:
            case MODULO:
            case POWER:
                ensureArgsOfType(functionExpr, TypeInt.INT, TypeInt.INT);
                return TypeInt.INT;
            // (BOOL, BOOL) -> BOOL
            case AND:
            case OR:
            case XOR:
                ensureArgsOfType(functionExpr, TypeBool.BOOL, TypeBool.BOOL);
                return TypeBool.BOOL;
            // (a, a) -> BOOL
            case EQUALS:
            case NOT_EQUALS:
                ensureArgNum(functionExpr, 2);
                ensureEqualTypes(functionExpr);
                return TypeBool.BOOL;
            // (INT, INT) -> BOOL
            case GREATER_THAN:
            case GREATER_EQUALS:
            case LESS_THAN:
            case LESS_EQUALS:
                ensureArgsOfType(functionExpr, TypeInt.INT, TypeInt.INT);
                return TypeBool.BOOL;
            default:
                throw new InternalTypeCheckException(
                        functionExpr,
                        "Unkown operator: " + functionExpr.getOperation());
        }
    }

    @Override
    public Type visitLiteral(LiteralExpr literalExpr) {
        return literalExpr.getValue().getType();
    }

    @Override
    public Type visitVariable(VariableExpr variableExpr) {
        Type varType = variableTypeContext.get(variableExpr.getVariableName());
        if (varType == null) {
            throw new InternalTypeCheckException(
                    variableExpr,
                    "Don't know type of variable: " + variableExpr.getVariableName());
        } else {
            return varType;
        }
    }

    private int ensureArgNum(FunctionExpr funExpr, int expectedNum) {
        List<Expression> args = funExpr.getArguments();
        int argLength = args.size();
        if (argLength != expectedNum) {
            throw new InternalTypeCheckException(
                    funExpr,
                    "Expected # of arguments is " + expectedNum +
                            ", but actual # of arguments is " + argLength + ".");
        }
        return argLength;
    }

    private void ensureArgsOfType(FunctionExpr funExpr, Type... expectedTypes) {
        int argNum = ensureArgNum(funExpr, expectedTypes.length);

        List<Expression> args = funExpr.getArguments();

        for (int i = 0; i < argNum; i++) {
            Expression arg = args.get(i);
            Type argType = arg.takeVisitor(this);
            if (!argType.checksAgainst(expectedTypes[i])) {
                throw new InternalTypeCheckException(
                        arg,
                        "Expected type " + expectedTypes[i] +
                                ", but actual type is: " + argType + ".");
            }
        }
    }

    private void ensureEqualTypes(FunctionExpr funExpr) {
        List<Expression> args = funExpr.getArguments();

        Type firstType = args.get(0).takeVisitor(this);

        for (int i = 0; i < args.size(); i++) {
            Expression arg = args.get(i);
            Type argType = arg.takeVisitor(this);
            if (!argType.checksAgainst(firstType)) {
                throw new InternalTypeCheckException(
                        arg,
                        "Expected equal types but got " + argType +
                                "conflicting with " + firstType + ".");
            }
        }
    }

}
