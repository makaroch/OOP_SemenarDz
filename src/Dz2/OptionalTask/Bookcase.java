package Dz2.OptionalTask;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bookcase implements Iterable<Book> {
    private List<Book> books;
    private final int capacity;
    private int currentCapacity;

    public Bookcase(int capacity) {
        books = new ArrayList<>();
        currentCapacity = 0;
        this.capacity = capacity;
    }
    @Override
    public Iterator<Book> iterator() {
        return books.iterator();
    }
    protected int getCapacity() {
        return capacity;
    }

    protected int getCurrentCapacity() {
        return currentCapacity;
    }

    protected void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    protected List<Book> getBooks() {
        return books;
    }

    protected void setBooks(List<Book> books) {
        this.books = books;
    }
}
