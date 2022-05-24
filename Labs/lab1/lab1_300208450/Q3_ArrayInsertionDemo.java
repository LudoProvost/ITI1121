public class Q3_ArrayInsertionDemo {

    public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert) {
        int[] newArray = new int[beforeArray.length + 1];
        for (int i = 0; i < indexToInsert; i++) {
            newArray[i] = beforeArray[i];
        }

        newArray[indexToInsert] = valueToInsert;

        for (int i = indexToInsert; i < beforeArray.length; i++) {
            newArray[i+1] = beforeArray[i];
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 4, 7, 9, 6};
        int valueToInsert = 15;
        int indexToInsert = 3;
        System.out.println("Array before insertion:");
        for (int value : array) {
            System.out.println(value);
        }
        array = insertIntoArray(array, indexToInsert, valueToInsert);
        System.out.println("Array after insertion of " + valueToInsert + " at position " + indexToInsert + ":");
        for (int value : array) {
            System.out.println(value);
        }
    }
}
