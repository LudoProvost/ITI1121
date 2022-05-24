//Ludovic Provost
//300208450

import java.util.Scanner;

public class A1Q2{

	public static int myCalc(int[] intArray, int n) {
		int R = 0;
		int i;
		for (i = 0; i < intArray.length; i++) {

			//counts num of pos int in intArray
			if (intArray[i] > 0) {
				R++;
			}

			//counts num of neg int in intArray
			else if (intArray[i] < 0) {
				R--;
			}
		}
		return R;
	}

	public static void main(String args[]) {
		System.out.println("Please enter an array of values separated by commas : "); //asks user for values
		Scanner sc = new Scanner(System.in);
		String[] numbers = sc.nextLine().split(","); //scans and splits ints to a String[]
		int[] intArray = new int[numbers.length];

		//converts string array to int array
		for (int i = 0; i < numbers.length; i++) {
			intArray[i] = Integer.parseInt(numbers[i]);
		}
		int R = myCalc(intArray, intArray.length); //calls myCalc func with user inputs
		System.out.println("The number of positive elements minus the number of negative elements is: "+R);

		}
}