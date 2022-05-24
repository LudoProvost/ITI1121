//Ludovic Provost
//300208450

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A1Q5{
	public static void main(String[] args){
		String lineOfArray;
		List<String> listOfStrings = new ArrayList<>();
		System.out.println("Enter the array of arrays one row per line. Enter an empty line when you are done.\nElements of each row should be separated by commas: "); //asks user input
		Scanner sc = new Scanner(System.in);

		//accepts inputs until condition(1) is true
		while (true) {
			lineOfArray = sc.nextLine();

			//condition(1): if user inputs empty line (Enter key)
			if (lineOfArray.equals("")) {
				break;
			}
			listOfStrings.add(lineOfArray);
		}

		int[][] arrayOfArrays = new int[listOfStrings.size()][];

		//adds line of ints to arrayOfArrays
		for (int i = 0; i < listOfStrings.size(); i++) {
			String[] line = listOfStrings.get(i).split(","); //splits ints at the commas
			arrayOfArrays[i] = new int[line.length];

			//converts string array to int array
			for (int j = 0; j < line.length; j++) {
				arrayOfArrays[i][j] = Integer.parseInt(line[j]);
			}
		}

		display(arrayOfArrays);

	}

	public static void display(int[][] arrayOfArrays) {
		System.out.println("The array of arrays is: ");

		//prints row
		for (int i = 0; i < arrayOfArrays.length; i++) {
			System.out.print("Row "+ i +" : ");

			//prints int
			for (int j = 0; j < arrayOfArrays[i].length; j++) {
				System.out.print(arrayOfArrays[i][j] + "  ");
			}
			System.out.print("\n");
		}
	}
}