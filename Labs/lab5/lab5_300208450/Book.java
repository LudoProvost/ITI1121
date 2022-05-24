import java.util.Objects;

public class Book {

    private String author;
    private String title;
    private int year;

    public Book (String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

//    public boolean equals(Object other) {
//        if (other == null) {
//            return false;
//        }
//        if (!(other instanceof Book o)) {
//            return false;
//        }
//
////        if ((this.author == null && o.author != null)) {
////            return false;
////        }
//
//        if (this.author == null) {
//            return o.author == null;
//        }
//
//
//        return (this.author.equals(o.author) && this.title.equals(o.title) && this.year == o.year);
//    }


    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Book book = (Book) other;

        if (year != book.year) return false;
        if (!Objects.equals(author, book.author)) return false;
        return Objects.equals(title, book.title);
    }
    

    public String toString() {
        return  this.author + ":" + this.title + " (" + this.year + ")";
    }
}
