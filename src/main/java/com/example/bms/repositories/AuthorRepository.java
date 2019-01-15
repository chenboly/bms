package com.example.bms.repositories;

import com.example.bms.models.Author;
import com.example.bms.repositories.Providers.AuthorProviders;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AuthorRepository {

    @SelectProvider(type = AuthorProviders.class, method = "getAllAuthorsProvider")

    List<Author> getAllAuthors();

}
