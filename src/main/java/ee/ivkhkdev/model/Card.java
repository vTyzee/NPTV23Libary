package ee.ivkhkdev.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Card implements Serializable {
    private UUID id;
    private Book book;
    private User user;
    private LocalDate borrowedBookDate;
    private LocalDate returnedBookDate;

    public Card() {
        this.id = UUID.randomUUID();
    }

    public Card(Book book, User user, LocalDate borrowedBookDate, LocalDate returnedBookDate) {
        this.book = book;
        this.user = user;
        this.borrowedBookDate = borrowedBookDate;
        this.returnedBookDate = returnedBookDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getBorrowedBookDate() {
        return borrowedBookDate;
    }

    public void setBorrowedBookDate(LocalDate borrowedBookDate) {
        this.borrowedBookDate = borrowedBookDate;
    }

    public LocalDate getReturnedBookDate() {
        return returnedBookDate;
    }

    public void setReturnedBookDate(LocalDate returnedBookDate) {
        this.returnedBookDate = returnedBookDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) && Objects.equals(book, card.book) && Objects.equals(user, card.user) && Objects.equals(borrowedBookDate, card.borrowedBookDate) && Objects.equals(returnedBookDate, card.returnedBookDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book, user, borrowedBookDate, returnedBookDate);
    }

    @Override
    public String toString() {
        return "Cards{" +
                "id=" + id +
                ", book=" + book +
                ", user=" + user +
                ", borrowedBookDate=" + borrowedBookDate +
                ", returnedBookDate=" + returnedBookDate +
                '}';
    }
}
