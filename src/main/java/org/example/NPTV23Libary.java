package org.example;

import org.example.Services.BookService;
import org.example.Services.UserService;
import org.example.interfaces.impl.ConsoleInput;
import org.example.interfaces.impl.ConsoleUserProvider;
import org.example.interfaces.impl.InputBook;

public class NPTV23Libary {
    public static void main(String[] args) {
        // Создаем необходимые сервисы и провайдеры
        ConsoleInput consoleInput = new ConsoleInput();
        InputBook inputBook = new InputBook();
        BookService bookService = new BookService(inputBook);
        ConsoleUserProvider userProvider = new ConsoleUserProvider();
        UserService userService = new UserService(userProvider);

        // Создаем приложение
        App app = new App(bookService, userService, consoleInput);

        // Запуск приложения
        app.run();
    }
}
