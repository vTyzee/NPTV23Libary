package org.example.handlers;

import org.example.App;
import org.example.interfaces.BookProvider;
import org.example.interfaces.InputProvider;
import org.example.model.Author;
import org.example.model.Book;

import java.util.Arrays;

public class BookHandler {
    private final InputProvider inputProvider;
    private final BookProvider bookProvider;

    // Constructor accepting InputProvider and BookProvider
    public BookHandler(InputProvider inputProvider, BookProvider bookProvider) {
        this.inputProvider = inputProvider;
        this.bookProvider = bookProvider;
    }

    // Method to add a book
    public void addBook() {
        Book book = bookProvider.createBook(inputProvider);  // Create a new book using input

        // Loop through the App.books array to find an available spot
        for (int i = 0; i < App.books.length; i++) {
            if (i == 0 && App.books[i] == null) {
                App.books[i] = book;
                break;
            } else if (i > 0 && App.books[i] == null) {
                App.books[i] = book;
                break;
            } else {
                continue;
            }
        }

        // Just for demonstration, assigning the book to the first slot if not added
        App.books[0] = book;
    }

    public void listBooks() {
        boolean hasBooks = false; // Флаг для проверки наличия книг
        for (Book book : App.books) {
            if (book != null) {
                System.out.println("Название книги: " + book.getTitle());
                System.out.println("Год публикации: " + book.getPublisherYear());

                // Вывод авторов
                System.out.println("Авторы:");
                for (Author author : book.getAuthors()) {
                    if (author != null) {
                        System.out.println("- Имя: " + author.getAuthorName() + ", Фамилия: " + author.getAuthorSurname());
                    }
                }

                System.out.println("------------------------");
                hasBooks = true;
            }
        }

        if (!hasBooks) {
            System.out.println("В системе нет добавленных книг.");
        }
    }
    public void findBookByTitle() {
        System.out.print("Введите название книги для поиска: ");
        String title = inputProvider.getInput(); // Получаем название от пользователя
        boolean found = false;

        for (Book book : App.books) {
            if (book != null && book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Книга найдена!");
                System.out.println("Название: " + book.getTitle());
                System.out.println("Год публикации: " + book.getPublisherYear());

                // Вывод авторов
                System.out.println("Авторы:");
                for (Author author : book.getAuthors()) {
                    if (author != null) {
                        System.out.println("- Имя: " + author.getAuthorName() + ", Фамилия: " + author.getAuthorSurname());
                    }
                }

                System.out.println("------------------------");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Книга с таким названием не найдена.");
        }
    }

}
