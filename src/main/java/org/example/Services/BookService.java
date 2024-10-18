package org.example.Services;

import org.example.interfaces.BookProvider;
import org.example.interfaces.Input;
import org.example.model.Book;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private final List<Book> books = new ArrayList<>();
    private final BookProvider bookProvider;

    public BookService(BookProvider bookProvider) {
        this.bookProvider = bookProvider;
    }

    public void add(Input input) {
        books.add(bookProvider.createBook(input));
    }

    public List<Book> listBooks() {
        return new ArrayList<>(books);
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Метод для выдачи книги пользователю
    public void lendBookToUser(String title, User user) {
        Book book = findBookByTitle(title);
        if (book != null && book.getBorrower() == null) {
            book.setBorrower(user);
            System.out.println("Книга '" + book.getTitle() + "' выдана пользователю " + user.getName());
        } else if (book != null) {
            System.out.println("Книга уже выдана другому пользователю.");
        } else {
            System.out.println("Книга не найдена.");
        }
    }
}
