package org.example;

import org.example.Services.BookService;
import org.example.Services.UserService;
import org.example.interfaces.Input;
import org.example.model.Book;
import org.example.model.User;

public class App {
    public static Book[] books = new Book[100];

    private final BookService bookService;
    private final UserService userService;
    private final Input input;

    public App(BookService bookService, UserService userService, Input input) {
        this.bookService = bookService;
        this.userService = userService;
        this.input = input;
    }

    public void run() {
        System.out.println("Добро пожаловать!");
        boolean repeat = true;
        do {
            System.out.println("Список задач:");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Вывести все книги");
            System.out.println("3. Поиск книги по названию");
            System.out.println("4. Управление читателями");
            System.out.println("5. Выдать книгу пользователю");
            System.out.print("Введите номер задачи: ");

            int task;
            try {
                task = Integer.parseInt(input.getInput());
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите число.");
                continue;
            }

            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    System.out.println("----- Добавление книги -----");
                    bookService.add(input);  // Добавление книги
                    break;
                case 2:
                    System.out.println("----- Список книг -----");
                    System.out.println(bookService.listBooks());  // Вывод списка книг
                    break;
                case 3:
                    System.out.println("----- Поиск книги -----");
                    System.out.print("Введите название книги: ");
                    String title = input.getInput();
                    Book book = bookService.findBookByTitle(title);
                    if (book != null) {
                        System.out.println(book);
                    } else {
                        System.out.println("Книга не найдена.");
                    }
                    break;
                case 4:
                    System.out.println("----- Управление читателями -----");
                    userService.manageUsers(input);  // Управление читателями
                    break;
                case 5:
                    System.out.println("----- Выдача книги пользователю -----");
                    // Выводим список пользователей, чтобы выбрать
                    System.out.println("Список пользователей:");
                    System.out.println(userService.printListUsers());

                    System.out.print("Введите имя пользователя для выдачи книги: ");
                    String userName = input.getInput();
                    System.out.print("Введите email пользователя: ");
                    String userEmail = input.getInput();
                    User user = new User(userName, userEmail);

                    // Проверяем наличие книги и выдаем ее пользователю
                    System.out.print("Введите название книги: ");
                    String bookTitle = input.getInput();
                    bookService.lendBookToUser(bookTitle, user);
                    break;
                default:
                    System.out.println("Неверный номер задачи.");
                    break;
            }
        } while (repeat);

        System.out.println("До свидания :)");
    }
}
