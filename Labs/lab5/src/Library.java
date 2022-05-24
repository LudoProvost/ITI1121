import java.util.ArrayList;

public class Library {

    private ArrayList<Book> library = new ArrayList<Book>();

    public Book getBook(int i) {
      return library.get(i);
    }

    public int getSize() {
      return library.size();

    }
    public void addBook (Book b) {
        library.add(b);
    }

    public void sort() {
        new BookComparator();
        for (int i = 0; i < library.size() - 1;i++) {
            for (int j = 0; j < library.size() - i - 1; j++) {
                if (new BookComparator().compare(getBook(j), getBook(j + 1)) > 0) {
                    Book temp = getBook(j);
                    library.set(j, getBook(j + 1));
                    library.set(j + 1, temp);
                }
            }
        }
    }


    public void printLibrary() {
        for (int i = 0; i < library.size(); i++) {
            System.out.println(getBook(i));
        }
    }
}
