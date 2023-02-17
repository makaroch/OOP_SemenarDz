package Dz2.OptionalTask;

import java.util.List;

public class Librarian implements WorkBookcase{
    private int correntIndexBook;
    @Override
    public boolean addBook(Book book, Bookcase bookcase) {

        if (!(bookcase.getCurrentCapacity() < bookcase.getCapacity())){
            System.out.println("Шкаф заполнен");
            return false;
        }
        List<Book> books = bookcase.getBooks();
        books.add(book);
        bookcase.setBooks(books);
        bookcase.setCurrentCapacity(bookcase.getCurrentCapacity()+1);
        return true;
    }
    @Override
    public boolean deleteBook(Book book, Bookcase bookcase){
       if(containsBook(book, bookcase)){
           List<Book> list = bookcase.getBooks();
           list.remove(correntIndexBook);
           bookcase.setBooks(list);
           bookcase.setCurrentCapacity(bookcase.getCurrentCapacity()-1);
           return true;
       }
        System.out.println("Нет такой");
       return false;
    }
    @Override
    public Book getBook(Book book, Bookcase bookcase) {
       if (deleteBook(book, bookcase)){
          return book;
       }
       return null;
    }

    @Override
    public int getQuantityBook(Bookcase bookcase) {
        return bookcase.getCurrentCapacity();
    }

    @Override
    public boolean containsBook(Book book, Bookcase bookcase) {
        List<Book> list = bookcase.getBooks();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(book)){
                correntIndexBook = i;
                return true;
            }
        }
        return false;
    }
}
