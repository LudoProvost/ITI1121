//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class A1Q5_test{
//    public static void main(String[] args){
//        String lineOfArray;
//        int[] array = new int[1];
//        System.out.println("Enter the array of arrays one row per line. Enter an empty line when you are done.\nElements of each row should be separated by commas: ");
//        Scanner sc = new Scanner(System.in);
//
//        while (true) {
//            lineOfArray = sc.nextLine();
//            if (lineOfArray.equals("")) {
//                break;
//            }
//            String[] temp_array = lineOfArray.split(",");
//            for (int i = 0; i < temp_array.length; i++) {
//                array[i] = Integer.parseInt(temp_array[i]);
//
//
//            }
//        }
//
//        int[][] arrayOfArrays = new int[array.length][];
//
//        for (int i = 0; i < array.length; i++) {
//            String[] line = listOfStrings.get(i).split(",");
//            arrayOfArrays[i] = new int[line.length];
//            for (int j = 0; j < line.length; j++) {
//                arrayOfArrays[i][j] = Integer.parseInt(line[j]);
//            }
//        }
//
//        display(arrayOfArrays);
//
//    }
//
//    public static void display(int[][] arrayOfArrays) {
//        System.out.println("The array of arrays is: ");
//        for (int i = 0; i < arrayOfArrays.length; i++) {
//            System.out.print("Row "+ i +" : ");
//            for (int j = 0; j < arrayOfArrays[i].length; j++) {
//                System.out.print(arrayOfArrays[i][j] + "  ");
//            }
//            System.out.print("\n");
//        }
//    }
//}