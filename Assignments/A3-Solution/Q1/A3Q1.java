import java.util.Scanner;

public class A3Q1{
	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
		String userInput;
		int output;
		boolean continueProcessing = true;
		
		while(continueProcessing){
			try{
			  //prompt the user to enter an expression
			  System.out.println("Enter your postfix expression: ");
			  PostFixHandler postFixHandler = new PostFixHandler();	
			  //pass the expression to the handler
			  output = postFixHandler.processExpression(scan.nextLine());
			  //display the output to the user
			  System.out.println("output: " + output);
			}
			//catch the different types of exceptions and diplay correponding message to the user
			catch (WrongExpressionFormatException e){        
			  System.out.println(e.getMessage()+". This expression has a wrong format.");
			}
			catch (OperatorNotSupportedException e){        
			  System.out.println(e.getMessage()+". The operator you entered is not supported.");
			} 
			catch (ArithmeticException e){        
			  System.out.println(e.getMessage());
			} 		
			// prompt the user if he has another expression.
			System.out.print("Do you want to enter another expression to evaluate? (Y/N): ");
			userInput = scan.nextLine().toLowerCase();
			continueProcessing = userInput.equals("y");
      }
	}
}