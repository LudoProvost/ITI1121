public class Q3_ReverseSortDemo {
    public static void main(String[] args) {
        char[] unorderedLetters;
        unorderedLetters = new char[]{'b', 'm', 'z', 'a', 'u'};
        reverseSort(unorderedLetters);
        for (int i = 0; i < unorderedLetters.length; i++) {
            System.out.print(unorderedLetters[i]);
        }
    }

    public static void reverseSort(char[] values) {
       for (int i = 0; i < values.length; i++) {
           for (int j = 0; j < values.length - i - 1; j++) {
               if (values[j] < values[j + 1]) {
                   char temp = values[j + 1];
                   values[j + 1] = values[j];
                   values[j] = temp;
               }
           }
       }
    }
}
