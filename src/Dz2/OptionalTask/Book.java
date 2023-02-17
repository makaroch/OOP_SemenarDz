package Dz2.OptionalTask;

import java.util.Objects;

public class Book {
    private final String name;
    private final String genre;
    private final String author;
    private final int numberOfPages;

    public Book(String name, String genre, String author, int numberOfPages) {
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.numberOfPages = numberOfPages;
    }
    public String getName() {
        return name;
    }
    public String getGenre() {
        return genre;
    }
    public String getAuthor() {
        return author;
    }
    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return numberOfPages == book.numberOfPages && Objects.equals(name, book.name) && Objects.equals(genre, book.genre) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, genre, author, numberOfPages);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
