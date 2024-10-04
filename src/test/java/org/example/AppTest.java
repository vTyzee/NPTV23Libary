package org.example;

import org.example.handlers.BookHandler;
import org.example.interfaces.BookProvider;
import org.example.interfaces.InputProvider;
import org.example.model.Author;
import org.example.model.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


class AppTest {
    ByteArrayOutputStream outDefault;
    ByteArrayOutputStream outContent;
    @BeforeEach
    void setUp() {
        outDefault= new ByteArrayOutputStream();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(new PrintStream(outDefault));
    }
    @Test
    void testAppRunExit() {
        InputProvider inputMock = Mockito.mock(InputProvider.class);
        when(inputMock.getInput()).thenReturn("0");
        BookProvider bookProviderMock = Mockito.mock(BookProvider.class);
        Author[] authors = new Author[0];
        when(bookProviderMock.createBook(inputMock)).thenReturn(new Book("War n' peace", authors, 2000));
        authors = new Author[1];
        Author author = new Author("Lev", "Tolstoy");
        authors[0] = author;
        BookHandler bookHandler = new BookHandler(inputMock, bookProviderMock);
        App app = new App(bookHandler, inputMock);
        app.run();
        String outContentString = outContent.toString();
        System.setOut(new PrintStream(outDefault));
        System.out.println(outContentString);
        assertTrue(outContent.toString().contains("До свидания :)"));
    }
}