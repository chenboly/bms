package com.example.bms.models;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class Book {

    private Integer id;
    private String title;
    private String isbn;
    private String book_image;
    private List<Author> authors;
    private Category category;
    private Date publishDate;
    private boolean status;
    private Timestamp createdAt;

    public Book() {
    }

    public Book(Integer id, String title, String isbn, String book_image, List<Author> authors, Category category, Date publishDate, boolean status, Timestamp createdAt) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.book_image = book_image;
        this.authors = authors;
        this.category = category;
        this.publishDate = publishDate;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBook_image() {
        return book_image;
    }

    public void setBook_image(String book_image) {
        this.book_image = book_image;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title='" + title + '\'' + ", isbn='" + isbn + '\'' + ", book_image='" + book_image + '\'' + ", authors=" + authors + ", category=" + category + ", publishDate=" + publishDate + ", status=" + status + ", createdAt=" + createdAt + '}';
    }
}
