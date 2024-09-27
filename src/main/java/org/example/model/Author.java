package org.example.model;

import java.util.Objects;
import java.util.UUID;

public class Author {
    private UUID id;
    private String authorName;
    private String authorSurname;

    // Default constructor
    public Author() {
        this.id = UUID.randomUUID(); // Generate a random UUID by default
    }

    // Constructor with parameters
    public Author(String authorName, String authorSurname) {
        this.id = UUID.randomUUID(); // Generate a random UUID
        this.authorName = authorName;
        this.authorSurname = authorSurname;
    }

    // Getter and Setter for 'id'
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    // Getter and Setter for 'authorName'
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    // Getter and Setter for 'authorSurname'
    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    // toString method
    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", authorSurname='" + authorSurname + '\'' +
                '}';
    }

    // equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) &&
                Objects.equals(authorName, author.authorName) &&
                Objects.equals(authorSurname, author.authorSurname);
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(id, authorName, authorSurname);
    }
}
