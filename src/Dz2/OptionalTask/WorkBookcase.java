package Dz2.OptionalTask;

public interface WorkBookcase {
    boolean addBook(Book book, Bookcase bookcase);
    boolean deleteBook(Book book, Bookcase bookcase);
    Book getBook(Book book, Bookcase bookcase);
    int getQuantityBook(Bookcase bookcase);
    boolean containsBook(Book book, Bookcase bookcase);

}

