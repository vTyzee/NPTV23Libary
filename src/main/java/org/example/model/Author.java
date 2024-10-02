package org.example.model;


import java.util.UUID;

public class Author {
    private UUID id;
    private String authorName;
    private String authorSurname;

    // Default constructor
    public Author() {
        this.id = UUID.randomUUID();
    }

    // Constructor with parameters
    public Author(String authorName, String authorSurname) {
        this.id = UUID.randomUUID();
        this.authorName = authorName;
        this.authorSurname = authorSurname;
    }

    // Getters and Setters
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", authorSurname='" + authorSurname + '\'' +
                '}';
    }
}
