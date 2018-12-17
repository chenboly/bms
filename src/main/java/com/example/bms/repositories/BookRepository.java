package com.example.bms.repositories;

import com.example.bms.models.Book;
import com.example.bms.models.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository {

//    This is the method using join table book and category together
//    @Select("SELECT * FROM tb_book WHERE status IS TRUE ORDER BY id")
//    @Select("SELECT * FROM tb_book b INNER JOIN tb_category c ON b.cat_id = c.id")
//    @Select("SELECT b.id as b_id, b.title, b.isbn, b.book_image, b.publish_date, " +
//            "b.status as b_status, b.created_at as b_created_at, " +
//            "c.id as c_id, c.name, c.status as c_status, c.created_at as c_created_at " +
//            "FROM tb_book b INNER JOIN tb_category c ON b.cat_id = c.id")
//    @Results({
//            @Result(column = "b_id", property = "id"),
//            @Result(column = "isbn",property = "ISBN"),
//            @Result(column = "book_image", property = "bookImage"),
//            @Result(column = "publish_date", property = "publishDate"),
//            @Result(column = "b_status", property = "status"),
//            @Result(column = "b_created_at", property = "createdAt"),
//
//            @Result(column = "c_id", property = "category.id"),
//            @Result(column = "name", property = "category.name"),
//            @Result(column = "c_status", property = "category.status"),
//            @Result(column = "c_created_at", property = "category.createdAt")
//    })

//    we can use select one method of mybatics
    @Select("SELECT * FROM tb_book")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "cat_id", property = "category.id"),
            @Result(column = "isbn", property = "ISBN"),
            @Result(column = "book_image", property = "bookImage"),
            @Result(column = "publish_date", property = "publishDate"),
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "cat_id", property = "category", one = @One(select = "getCategoryById"))
    })
    List<Book> getAllBooks();

    @Select("SELECT * FROM tb_category WHERE id = #{cat_id}")
    @Results({
            @Result(column = "created_at", property = "createdAt")
    })
    Category getCategoryById(@Param("cat_id") Integer id);
}
