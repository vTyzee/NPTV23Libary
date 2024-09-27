package org.example;

import org.example.services.BookService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    Scanner scanner;

    // Constructor accepting Scanner for dependency injection
    public App(Scanner scanner) {
        this.scanner = scanner;
    }

    // Default constructor using System.in
    public App() {
        this(new Scanner(System.in));
    }

    public void run() {
        boolean repeat = true;
        do {
            System.out.println("Список задач:");
            System.out.println("0. Выход.");
            System.out.println("1. Добавить книгу.");
            System.out.print("Введите номер задачи: ");

            try {
                int task = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer

                switch (task) {
                    case 0:
                        repeat = false;
                        break;
                    case 1:
                        System.out.println("Добавить книгу");
                        BookService bookService = new BookService();
                        // Here you can add logic to handle book addition if needed
                        break;
                    default:
                        System.out.println("Выберите из списка!");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Пожалуйста, введите целое число!");
                scanner.nextLine(); // Clear the invalid input from the scanner buffer
            }

        } while (repeat);

        System.out.println("Heataega!");
        scanner.close(); // Make sure to close the scanner
    }
}
