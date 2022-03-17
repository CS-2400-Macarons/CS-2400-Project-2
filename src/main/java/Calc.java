public class Calc
{

    //        Algorithm convertToPostfix(infix)
//// Converts an infix expression to an equivalent postfix expression.
//            operatorStack = a new empty stack
//            postfix = a new empty string
//        while (infix has characters left to parse)
//        {
//            nextCharacter = next nonblank character of infix
//            switch (nextCharacter)
//            {
//                case variable:
//                    Append nextCharacter to postfix
//                    break
//                case '^' :
//                    5.16
//                    operatorStack.push(nextCharacter)
//                    break
//                case '+' : case '-' : case '*' : case '/' :
//                while (!operatorStack.isEmpty() and
//                precedence of nextCharacter <= precedence of
//                operatorStack.peek())
//            {
//                Append operatorStack.peek() to postfix
//                operatorStack.pop()
//            }
//            operatorStack.push(nextCharacter)
//            break
//                case '( ' :
//                    operatorStack.push(nextCharacter)
//                    break
//                case ')' : // Stack is not empty if infix expression is valid
//                    topOperator = operatorStack.pop()
//                    while (topOperator != '(')
//                    {
//                        Append topOperator to postfix
//                        topOperator = operatorStack.pop()
//                    }
//                    break
//                default: break // Ignore unexpected characters
//            }
//        }
//        while (!operatorStack.isEmpty())
//        {
//            topOperator = operatorStack.pop()
//            Append topOperator to postfix
//        }
//        return postfix

    public String convertToPostfix(String infix)
    {
        return null;
    }

//        // Evaluates a postfix expression.
//        valueStack = a new empty stack
//        while (postfix has characters left to parse)
//        {
//            nextCharacter = next nonblank character of postfix
//            switch (nextCharacter)
//            {
//                case variable:
//                    valueStack.push(value of the variable nextCharacter)
//                    break
//                case '+' : case '-' : case '*' : case '/' : case '^' :
//                operandTwo = valueStack.pop()
//                operandOne = valueStack.pop()
//                result = the result of the operation in nextCharacter and its
//                operands
//                operandOne and operandTwo
//                valueStack.push(result)
//                break
//                default: break // Ignore unexpected characters
//            }
//        }
//        return valueStack.peek()

    public int evaluatePostfix(String postfix)
    {

        return 0;
    }
}