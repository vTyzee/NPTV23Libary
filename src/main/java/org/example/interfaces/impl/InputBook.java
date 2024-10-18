package org.example.interfaces.impl;

import org.example.interfaces.BookProvider;
import org.example.interfaces.Input;
import org.example.model.Author;
import org.example.model.Book;

public class InputBook implements BookProvider {

    @Override
    public Book createBook(Input input) {
        System.out.print("Введите название книги: ");
        String title = input.getInput();

        System.out.print("Введите автора: ");
        String authorFirstName = input.getInput();
        System.out.print("Введите фамилию автора: ");
        String authorLastName = input.getInput();

        Author author = new Author(authorFirstName, authorLastName);
        Author[] authors = {author};

        System.out.print("Введите год выпуска книги: ");
        int year;
        try {
            year = Integer.parseInt(input.getInput());
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат года.");
            return null;
        }

        return new Book(title, authors, year);
    }
}
