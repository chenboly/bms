package com.example.bms.services;

import com.example.bms.models.Book;
import com.example.bms.models.Form.BookForm;

import java.util.List;

public interface BookServices {

    boolean saveBook(BookForm bookForm);
    boolean saveBookAuthor(BookForm bookForm);
    List<Book> getAllBooks();
}
