import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import stackCalculator.Calculator;

public class CalculatorTest
{
    @Test
    void testingEmptyInfixExpression()
    {
        Calculator calc = new Calculator();

        String infix = "";
        String postfix = calc.convertToPostfix(infix);
        String numPostfix = "";
        int evaluation = calc.evaluatePostfix(numPostfix);

        assertEquals("", postfix);
        assertEquals(0, evaluation);
    }

    @Test
    void testingOneOperand()
    {
        Calculator calc = new Calculator();

        String infix = "a";
        String postfix = calc.convertToPostfix(infix);
        // Postfix: a
        // a = 1
        String numPostfix = "1";
        int evaluation = calc.evaluatePostfix(numPostfix);

        assertEquals("a", postfix);
        assertEquals(1, evaluation);
    }

    @Test
    void testingAdditionOperator()
    {
        Calculator calc = new Calculator();

        String infix = "a+b";
        String postfix = calc.convertToPostfix(infix);
        // Postfix: ab+
        // a = 1, b = 2
        String numPostfix = "12+";
        int evaluation = calc.evaluatePostfix(numPostfix);

        assertEquals("ab+", postfix);
        assertEquals(3, evaluation);
    }

    @Test
    void testingSubtractionOperator()
    {
        Calculator calc = new Calculator();

        String infix = "a-b";
        String postfix = calc.convertToPostfix(infix);
        // Postfix: ab-
        // a = 1, b = 2
        String numPostfix = "12-";
        int evaluation = calc.evaluatePostfix(numPostfix);

        assertEquals("ab-", postfix);
        assertEquals(-1, evaluation);
    }

    @Test
    void testingMultiplicationOperator()
    {
        Calculator calc = new Calculator();

        String infix = "a*b";
        String postfix = calc.convertToPostfix(infix);
        // Postfix: ab*
        // a = 1, b = 2
        String numPostfix = "12*";
        int evaluation = calc.evaluatePostfix(numPostfix);

        assertEquals("ab*", postfix);
        assertEquals(2, evaluation);
    }

    @Test
    void testingDivisionOperator()
    {
        Calculator calc = new Calculator();

        String infix = "a/b";
        String postfix = calc.convertToPostfix(infix);
        // Postfix: ab/
        // a = 6, b = 3
        String numPostfix = "63/";
        int evaluation = calc.evaluatePostfix(numPostfix);

        assertEquals("ab/", postfix);
        assertEquals(2, evaluation);
    }

    @Test
    void testingParentheses()
    {
        Calculator calc = new Calculator();

        String infix = "c*(a+b)";
        String postfix = calc.convertToPostfix(infix);
        // Postfix: cab+*
        // a = 1, b = 2, c = 3
        String numPostfix = "312+*";
        int evaluation = calc.evaluatePostfix(numPostfix);

        assertEquals("cab+*", postfix);
        assertEquals(9, evaluation);
    }

    @Test
    void testingPrecedence()
    {
        Calculator calc = new Calculator();

        String infix = "a*b/ (c-a) + d * e";
        String postfix = Calculator.convertToPostfix(infix);
        // Postfix = ab*ca-/de*+
        // a = 2, b = 3, c = 4, d = 5, e = 6
        String numPostfix = "23*42-/56*+";
        int evaluation = calc.evaluatePostfix(numPostfix);

        assertEquals("ab*ca-/de*+", postfix);
        assertEquals(33, evaluation);
    }
}