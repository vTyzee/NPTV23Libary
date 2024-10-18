package org.example.model;

public class Book {
    private String title;
    private Author[] authors;
    private int year;
    private User borrower; // Читатель, который взял книгу

    public Book(String title, Author[] authors, int year) {
        this.title = title;
        this.authors = authors;
        this.year = year;
        this.borrower = null; // Изначально книга не занята
    }

    public String getTitle() {
        return title;
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    @Override
    public String toString() {
        StringBuilder authorNames = new StringBuilder();
        for (Author author : authors) {
            authorNames.append(author.toString()).append(", ");
        }

        String borrowerInfo = (borrower != null) ? ", Взял: " + borrower.getName() : ", Доступна";
        return "Книга: " + title + ", Авторы: " + authorNames + "Год: " + year + borrowerInfo;
    }
}
