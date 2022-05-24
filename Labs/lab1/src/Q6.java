import java.util.Scanner;

public class Q6{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double[] notes = new double[10];
        for (int i = 0; i < 10; i++) {
            notes[i] = sc.nextDouble();
        }
        System.out.println("Average: " + calculateAverage(notes));
        System.out.println("Median: " + calculateMedian(notes));
        System.out.println("# failed: " + calculateNumberFailed(notes));
        System.out.println("# passed: " + calculateNumberPassed(notes));
    }

    public static double calculateAverage(double[] notes){
        double average = 0;
        for (double studentGrade : notes) {
            average += studentGrade;
        }
        return average / notes.length;
    }

    public static double calculateMedian(double[] notes){
        for (int i = 0; i < notes.length; i++) {
            for (int j = 0; j < notes.length - i - 1; j++) {
                if (notes[j] > notes[j + 1]) {
                    double temp = notes[j + 1];
                    notes[j + 1] = notes[j];
                    notes[j] = temp;
                }
            }
        }
        if (notes.length % 2 == 0) {
            return (notes[notes.length / 2] + notes[(notes.length / 2) - 1]) / 2;
        }
        else {
            return notes[notes.length / 2];
        }
    }

    public static int calculateNumberFailed(double[] notes){
        int failed = 0;
        for (double studentGrade : notes) {
            if (studentGrade < 50) {
                failed ++;
            }
        }
        return failed;
    }

    public static int calculateNumberPassed(double[] notes){
        int passed = 0;
        for (double studentGrade : notes) {
            if (studentGrade >= 50) {
                passed ++;
            }
        }
        return passed;
    }

}