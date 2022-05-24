//Ludovic Provost
//300208450

import java.util.Scanner;

public class A1Q1_old {
    public static void main(String[] args) {
        System.out.println("Please enter the number of sentences :");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Please enter an array of " + n + " sentences separated by commas:");
        Scanner array_sentences = new Scanner(System.in);
        String sentences = array_sentences.next();
        String[] split_sentences = sentences.split(",", n-1);
        for (String el : split_sentences) {
            System.out.println(el);
        }
        int[] answers = talk(split_sentences, n);
        System.out.println("The length of the longest sentence is: " + answers[0]);
        System.out.println("Sentences of the length are repeated : " + answers[1] + " time(s)");
    }


    public static int [] talk(String[] sentences, int n) {
        int [] answers = new int[] {0,0};
        int i;
        for (String sentence : sentences) {
            if (sentence.length() > answers[0]) {
                answers[1] = 0;
                answers[0] = sentence.length();
            }
            if (answers[0] != 0) {
                if (sentence.length() == answers[0]) {
                    answers[1]++;
                }
            }
        }
        return answers;
    }
}
