import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        int blabla = o1.getAuthor().compareTo(o2.getAuthor());
        if (blabla == 0) {
            blabla = o1.getTitle().compareTo(o2.getTitle());
            if (blabla == 0) {
                return Integer.compare(o1.getYear(), o2.getYear());
            }
            return blabla;
        }
        return blabla;
    }
}
