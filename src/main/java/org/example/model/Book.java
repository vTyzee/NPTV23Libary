package org.example.model;

import java.util.Arrays;
import java.util.UUID;

public class Book {
    private UUID id;
    private String title;
    private Author[] authors;
    private int publisherYear;

    // Default constructor
    public Book() {
        this.id = UUID.randomUUID();
    }

    // Constructor with parameters
    public Book(String title, Author[] authors, int publisherYear) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.authors = authors;
        this.publisherYear = publisherYear;
    }

    // Getters and Setters
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
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", publisherYear=" + publisherYear +
                '}';
    }
}
