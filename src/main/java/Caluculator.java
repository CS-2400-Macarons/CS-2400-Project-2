import java.lang.Math;

public class Caluculator
{
    public static void main(String[] args) {
        // Testing the given infix expression and values here
    }

    /** Enter JavaDoc here
     *
     * @param infix
     * @return
     */

    public String convertToPostfix(String infix)
    {
        LinkedStack<String> operatorStack = new LinkedStack<>();
        String postfix = "";
        int index = 0;

        while(index != (infix.length() - 1))
        {

            String nextCharacter = infix.substring(index, index + 1).toLowerCase();
            if(nextCharacter != " ")
            {
                switch (nextCharacter)
                {
                    case "a": case "b": case "c": case "d": case "e":
                    case "f": case "g": case "h": case "i": case "j":
                    case "k": case "l": case "m": case "n": case "o":
                    case "p": case "q": case "r": case "s": case "t":
                    case "u": case "v": case "w": case "x": case "y":
                    case "z":
                        postfix += nextCharacter;
                        break;

                    case "^":
                        operatorStack.push(nextCharacter);
                        break;

                    case "+" : case "-" : case "*" : case "/":
                        int nextCharPrecedence = 0;
                        int peekPrecedence = 0;

                        if(nextCharacter == "*" || nextCharacter == "/")
                        {
                            nextCharPrecedence = 2;
                        }
                        else
                        {
                            nextCharPrecedence = 1;
                        }

                        if(operatorStack.peek() == "*" || operatorStack.peek() == "/")
                        {
                            peekPrecedence = 2;
                        }
                        else
                        {
                            peekPrecedence = 1;
                        }

                        while(!operatorStack.isEmpty() && nextCharPrecedence <= peekPrecedence)
                        {
                            postfix += operatorStack.peek();
                            operatorStack.pop();
                        }
                        operatorStack.push(nextCharacter);
                        break;

                    case "(":
                        operatorStack.push(nextCharacter);
                        break;

                    case ")":
                        String topOperator = operatorStack.pop();
                        while (topOperator != "(")
                        {
                            postfix += topOperator;
                            topOperator = operatorStack.pop();
                        }
                        break;

                    default: break;
                }

                while (!operatorStack.isEmpty())
                {
                    String topOperator = operatorStack.pop();
                    postfix += topOperator;
                }
            }

            index++;
        }

        return postfix;
    }

    /** Enter Javadoc here
     *
     * @param postfix
     * @return
     */

    public static int evaluatePostfix(String postfix)
    {
        ArrayStack <Integer> valueStack = new ArrayStack<>();
        int index = 0;
        String nextCharacter;
        int result = 0;
        while(index != postfix.length())
        {
            nextCharacter = postfix.substring(index, index + 1);
            if(nextCharacter != " ")
            {
                switch (nextCharacter)
                {
                    case "0": case "1": case "2": case "3": case "4":
                    case "5": case "6": case "7": case "8": case "9":
                        valueStack.push(Integer.parseInt(nextCharacter));
                        
                        break;
                        
                    case "+": case "-": case "*": case "/": case "^":
                        
                            int operandTwo = valueStack.pop();
                            int operandOne = valueStack.pop();
    
                            if (nextCharacter.equals("+"))                         
                            result = operandOne + operandTwo;                                
                           

                            else if (nextCharacter.equals("-"))
                            result = operandOne - operandTwo;                                
                           

                            else if (nextCharacter.equals("*"))
                            result = operandOne * operandTwo;
                            
                            else if (nextCharacter.equals("/"))
                            result = operandOne / operandTwo;
                            

                            else if (nextCharacter.equals("^"))
                            result = (int) Math.pow(operandOne, operandTwo);
                         
                        valueStack.push(result);
                    
                    break;

                    default: break;

                }

            }
            index++;
        }

        return valueStack.peek();
    }
}
