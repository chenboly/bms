package com.example.bms.repositories;

import com.example.bms.models.Book;
import com.example.bms.models.Category;
import com.example.bms.repositories.Providers.CategoryProviders;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepository {

    @SelectProvider(type = CategoryProviders.class, method = "getAllCategoriesProvider")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "id", property = "books", many = @Many(select = "getAllBookByCategory"))
    })
    List<Category> getAllCategories();
    @Select("SELECT * FROM tb_book WHERE cat_id = #{id}")
    @Results({
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "publish_date", property = "publishDate")
    })
    List<Book> getAllBookByCategory(Integer id);
}
