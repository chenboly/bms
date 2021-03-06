package com.example.bms.services.impl;

import com.example.bms.models.Category;
import com.example.bms.repositories.CategoryRepository;
import com.example.bms.services.CategoryService;
import com.example.bms.utilities.Paginate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getOneCategoryById(Integer id) {
        return this.categoryRepository.getOneCategoryById(id);
    }

    @Override
    public List<Category> getAllCategories(String name) {
        return this.categoryRepository.getAllCategories(name);
    }

    @Override
    public List<Category> getAllCategoriesPaginate(String name, Paginate paginate) {
        return this.categoryRepository.getAllCategoriesPaginate(name, paginate);
    }

    @Override
    public int count(String name) {
        return this.categoryRepository.count(name);
    }

    @Override
    public boolean save(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public boolean update(Category category) {
        return this.categoryRepository.update(category);
    }

    @Override
    public Integer delete(Integer id) {
        return this.categoryRepository.delete(id);
    }
}
