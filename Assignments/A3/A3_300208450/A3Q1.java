/*******************************/
/*Students numbers: 300208450
/*Students full names: Ludovic Provost
/*******************************/

import java.util.Scanner;

public class A3Q1{
	public static void main(String[] args) {

		int output; // output of the expression evaluation
		String again = "Y";

		Scanner sc = new Scanner(System.in);

		while (again.equals("Y") || again.equals("y")) {
			System.out.print("Enter your postfix expression:");
			String g = sc.nextLine();

			PostFixHandler postfix = new PostFixHandler();
			try {
				output = postfix.processExpression(g);
				System.out.println("output: " + output);
			}
			catch(ArithmeticException|WrongExpressionFormatException|OperatorNotSupportedException ignored) { }

			System.out.print("Do you want to enter another expression to evaluate? (Y/N): ");
			again = sc.nextLine();
		}
	}
}