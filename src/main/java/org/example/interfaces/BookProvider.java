package org.example.interfaces;

import org.example.model.Book;

public interface BookProvider {
    Book createBook(InputProvider inputProvider);  // Method to create a book using input
}
