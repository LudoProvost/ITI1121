//Ludovic Provost
//300208450

import java.util.Scanner;

public class A1Q1 {
	
	public static int[] talk(String[] array, int n) {
		int[] results = new int[2];

		//loops through array of sentences
		for (String sentence : array) {

			//finds longest sentence
			if (sentence.length() > results[0]) {
				results[1] = 0;
				results[0] = sentence.length();
			}

			//counts how many times the length is repeated
			if (results[0] != 0) {
				if (sentence.length() == results[0]) {
					results[1]++;
				}
			}
		}
	  return results;
	}

	public static void main(String[] args) {


		System.out.println("Please enter the number of sentences : "); //asks user to enter num of sentences
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //scans user input
		System.out.println("Please enter an array of " + n + " sentences separated by commas : "); //asks user to enter sentences
		Scanner array_sentences = new Scanner(System.in);
		String sentences = array_sentences.nextLine(); //scans user input
		String[] split_sentences = sentences.split(","); //splits sentences at commas
		int[] answers = talk(split_sentences, n); //sends sentences to be processed by talk func
		System.out.println("The length of the longest sentence is : " + answers[0]);
		System.out.println("Sentences of the length are repeated : " + answers[1] + " time(s)");
	}
}