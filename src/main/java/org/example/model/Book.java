package org.example.model;

import java.util.Arrays;
import java.util.UUID;

public class Book {
    private UUID id;
    private String title;
    private Author[] authors = new Author[10];
    private int publisherYear;

    public Book() {
        this.id = UUID.randomUUID();
    }

    public Book(String title, Author[] authors, int publisherYear) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.authors = authors;
        this.publisherYear = publisherYear;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    public int getPublisherYear() {
        return publisherYear;
    }

    public void setPublisherYear(int publisherYear) {
        this.publisherYear = publisherYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (publisherYear != book.publisherYear) return false;
        if (!id.equals(book.id)) return false;
        if (!title.equals(book.title)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + Arrays.hashCode(authors);
        result = 31 * result + publisherYear;
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", publisherYear=" + publisherYear +
                '}';
    }
}
