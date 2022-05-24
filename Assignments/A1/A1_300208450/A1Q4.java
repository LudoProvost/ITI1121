//Ludovic Provost
//300208450

import java.util.Scanner;

public class A1Q4 {

    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int goals = getUserInput("Enter the number of the player goals during the season: "); //sends question to func getUserInput
        int assists = getUserInput("Enter the number of the player assists during the season: "); //sends question to func getUserInput
        int penalties = getUserInput("Enter the number of penalties during the season: "); //sends question to func getUserInput
        int matches = getUserInput("Enter the number of matches played: "); //sends question to func getUserInput
        int years = getUserInput("Enter the number of years of service: "); //sends question to func getUserInput
        System.out.println("The bonus code of this player is: " + getBonusCode(goals, assists, penalties, matches, years)); //prints answer + sends user inputs to func getBonusCode
    }

    public static int getUserInput(String question) {
        System.out.print(question); //asks user input
        int playerStat = sc.nextInt(); //scans user input

        //asks user input until input is correct
        while (playerStat<0) {
            System.out.print(question); //asks user input
            playerStat = sc.nextInt(); //scans user input
        }
        return playerStat;
    }

    public static int getBonusCode(int goals, int assists, int penalties, int matches, int years) {

        //conditions are met => bonus = no bonus (0)
        if (goals <= 20 && assists <= 25 && penalties >= 25) {
            return 0;
        }

        else if (years >= 5) {

            //conditions are met => bonus = full bonus (3)
            if (matches > 55) {
                return 3;
            }

            //conditions are met => bonus = partial bonus (2)
            else {
                return 2;
            }
        }

        //conditions are met => bonus = conditional bonus (1)
        else {
            return 1;
        }
    }

}
