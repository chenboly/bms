package com.example.bms.services;

import com.example.bms.models.Category;
import com.example.bms.utilities.Paginate;

import java.util.List;

public interface CategoryService {

    Category getOneCategoryById (Integer id);
    List<Category> getAllCategories(String name);
    List<Category> getAllCategoriesPaginate(String name, Paginate paginate);
    int count (String name);
    boolean save (Category category);
    boolean update(Category category);
    Integer delete (Integer id);
}
