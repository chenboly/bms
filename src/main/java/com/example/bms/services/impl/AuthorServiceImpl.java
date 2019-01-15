package com.example.bms.services.impl;

import com.example.bms.models.Author;
import com.example.bms.repositories.AuthorRepository;
import com.example.bms.services.AuthorServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorServices {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return this.authorRepository.getAllAuthors();
    }
}
