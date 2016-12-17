package stverificationstudio;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import stverificationstudio.expressions.Expression;
import stverificationstudio.expressions.FunctionExpr;
import stverificationstudio.expressions.LiteralExpr;
import stverificationstudio.expressions.Type;
import stverificationstudio.expressions.TypeEnum;
import stverificationstudio.expressions.TypeFactory;
import stverificationstudio.expressions.ValueBool;
import stverificationstudio.expressions.ValueInt;
import stverificationstudio.expressions.VariableExpr;
import stverificationstudio.typechecker.TypeCheckException;
import stverificationstudio.typechecker.TypeChecker;

public class TestTypeChecker {

	@Test
	public void testTypeCheck() throws TypeCheckException {
		// Colors = Red, Blue
		// Red == Blue && X == 3 && 5 + X == 8 && TRUE
		TypeEnum colorsEnum = TypeFactory.enumOfName("Colors", "Red", "Blue");
		Map<String, Type> varTypeCtx = new HashMap<>();
		varTypeCtx.put("X", TypeFactory.INT);
		
		Expression redEqualsBlue =
			eq(
				new LiteralExpr(colorsEnum.valueOf("Red")),
				new LiteralExpr(colorsEnum.valueOf("Blue")));
		
		Expression xEqualsThree =
			eq(
				var("X"),
				literal(3));
		
		Expression sumIsEleven = 
			eq(
				plus(literal(5), var("X")),
				literal(8));
		
		Expression trueExpr = literal(true);
		
		Expression expr =
			and(redEqualsBlue, and(xEqualsThree, and(sumIsEleven, trueExpr)));

		TypeChecker checker = new TypeChecker(varTypeCtx);
		Type type = checker.typeCheck(expr);
        Assert.assertEquals(type, TypeFactory.BOOL);
	}
	
	public static Expression and(Expression e1, Expression e2) {
		return new FunctionExpr(FunctionExpr.Operation.AND, Arrays.asList(e1, e2));
	}
	
	public static Expression plus(Expression e1, Expression e2) {
		return new FunctionExpr(FunctionExpr.Operation.PLUS, Arrays.asList(e1, e2));
	}
	
	public static Expression eq(Expression e1, Expression e2) {
		return new FunctionExpr(FunctionExpr.Operation.EQUALS, Arrays.asList(e1, e2));
	}
	
	public static Expression var(String name) {
		return new VariableExpr(name);
	}
	
	public static Expression literal(int i) {
		return new LiteralExpr(new ValueInt(i));
	}
	
	public static Expression literal(boolean b) {
		return new LiteralExpr(new ValueBool(b));
	}

}
