package com.example.bms.services.impl;
import com.example.bms.models.Book;
import com.example.bms.models.Form.BookForm;
import com.example.bms.repositories.BookRepository;
import com.example.bms.services.BookServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookServices {
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public boolean saveBook(BookForm bookForm) {
        return this.bookRepository.saveBook(bookForm);
    }

    @Override
    public boolean saveBookAuthor(BookForm bookForm) {
        return this.bookRepository.saveBookAuthor(bookForm);
    }

    @Override
    public List<Book> getAllBooks() {
        return this.bookRepository.getAllBooks();
    }
}
