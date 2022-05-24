public class Q3_SquareArray {

    public static int[] createArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i * i;
        }
        return array;
    }

    public static void main(String[] args) {
        int size = 13;
        int[] array = createArray(size);
        for (int i = 0; i < size; i++) {
            System.out.println("The square of " + i + " is: " + array[i]);
        }

    }
}
