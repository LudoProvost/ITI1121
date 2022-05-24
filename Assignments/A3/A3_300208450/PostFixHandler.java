/*******************************/
/*Students numbers: 300208450
/*Students full names: Ludovic Provost
/*******************************/

import java.lang.Math;

public class PostFixHandler{

    private static final String plus = "plus";
    private static final String min = "minus";
    private static final String multi = "multiply";
    private static final String div = "divide";
    private static final String sqrt = "squareRoot";

    public int processExpression(String postFixExp) throws WrongExpressionFormatException, OperatorNotSupportedException {
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        String[] inputs = postFixExp.split(" ");
        int num1, num2;

        for(int i = 0; i < inputs.length; i++) {

            if (inputs[i].equals(sqrt)) {
                int numSR = stack.pop();
                if (numSR < 0) {
                    throw new ArithmeticException("Can not do the square root of a negative number.");
                }
                int local = (int) Math.sqrt(numSR);
                stack.push(local);
            }
            else if( inputs[i].equals(plus) || inputs[i].equals(min) || inputs[i].equals(multi) || inputs[i].equals(div)) {
                try {
                    num2 = stack.pop();
                    num1 = stack.pop();
                } catch (NullPointerException e){
                    throw new WrongExpressionFormatException();
                }

                switch(inputs[i]) {
                    case plus: {
                        int local = num1 + num2;
                        stack.push(local);
                        break;
                    }

                    case min: {
                        int local = num1 - num2;
                        stack.push(local);
                        break;
                    }

                    case multi: {
                        int local = num1 * num2;
                        stack.push(local);
                        break;
                    }

                    case div: {
                        if (num2 == 0) {
                            num2 = 1;
//              throw new ArithmeticException("Can not divide by zero.");
                            System.out.println("Arithmetic Exception: Can not divide by zero."); // I can't throw AND continue? not sure what you want me to do.
                        }
                        int local = num1 / num2;
                        stack.push(local);
                        break;
                    }

                }
            } else {
                try {
                    stack.push(Integer.parseInt(inputs[i]));
                }
                catch (NumberFormatException e) {
                    if (inputs[i].matches(".*\\d+.*")) {
                        throw new WrongExpressionFormatException();
                    }
                    throw new OperatorNotSupportedException();
                }
            }
        }

        return stack.pop();
    }

}