package com.example.bms.services;

import com.example.bms.models.Category;

import java.util.List;

public interface CategoryService {

    Category getOneCategoryById (Integer id);
    List<Category> getAllCategories(String name);
    boolean save (Category category);
    boolean update(Category category);
    Integer delete (Integer id);
}
