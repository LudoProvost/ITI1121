import java.util.Scanner;

public class PostFixHandler{
	
  public int processExpression(String postFixExp) throws WrongExpressionFormatException, OperatorNotSupportedException{
    LinkedStack<Integer> stack = new LinkedStack<Integer>();  
	//your code here
    String input;
    int number1=0;
    int number2=0;
    int output = 0;

    Scanner tokenizer = new Scanner(postFixExp);

    while (tokenizer.hasNext())
    {
	  // if the next token is an int just push it in the stack
      if (tokenizer.hasNextInt())
		stack.push(tokenizer.nextInt());
      else{ // get the next non-int token, expected to be an operator
        input = tokenizer.next();
		// if we can't find an operand the format is wrong
        if (stack.isEmpty()){
          throw new WrongExpressionFormatException("WrongExpressionFormatException");
		}
		//if we get here then there is an operand in the stack, continue:
        number2 = stack.pop();
		if (  input.equals("divide")||input.equals("multiply")||input.equals("plus")||input.equals("minus") ){
			// these operators all need 2 operands so stack shoudn't be empty 
			if (stack.isEmpty()){
			  throw new WrongExpressionFormatException("WrongExpressionFormatException");
			}
			//there is an operand in the stack, continue:
			number1 = stack.pop();
		} else if (!input.equals("squareRoot")) {
			   //we don't support other operators other than the 4 above and squareRoot
			   throw new OperatorNotSupportedException("OperatorNotSupportedException " + input);
		}
        // if we got here then all is good so far we have the operand(s) and operator
		if(input.equals("squareRoot")){
			try{
				if (number2 < 0){
					throw new ArithmeticException("ArithmeticException: Square Root of Negative Number");
				}
			}catch (ArithmeticException e){
					System.out.println(e.getMessage());
					return 0;
				}			
          stack.push((int) Math.sqrt(number2));
		} else if(input.equals("plus")){
          stack.push(number1 + number2);
		} else if(input.equals("minus")){
          stack.push(number1 - number2);
		} else if(input.equals("multiply")){
          stack.push(number1 * number2);
		} else if(input.equals("divide")){
			try{
				if (number2 == 0){
					throw new ArithmeticException("Arithmetic Exception: Division by Zero");
				}
			}catch (ArithmeticException e){
				System.out.println("Arithmetic Exception: Division by Zero");
				number2 = 1;
				}
			stack.push(number1 / number2);
		} 
      }
    }

    // we need to return the output from the stack, shouldn't be empty yet
    if (stack.isEmpty()){
      throw new WrongExpressionFormatException("WrongExpressionFormatException");
	}
    output = stack.pop();
	
    // check that the stack is empty at the end
    if (!stack.isEmpty())
      throw new WrongExpressionFormatException("WrongExpressionFormatException");

    return output;
  }
}