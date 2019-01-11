package com.example.bms.controllers;

import com.example.bms.models.Category;
import com.example.bms.services.CategoryService;
import com.example.bms.utilities.Paginate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public String showAllCategory(@RequestParam(required = false) String name, Model model){
        List<Category> categories = this.categoryService.getAllCategories(name);
        model.addAttribute("categoryList", categories);
        return "admin/categories/list-all-category";
    }
    //for pagination
    @GetMapping("/all/paginate")
    public String showAllCategoryPaginate(@RequestParam(required = false) String name,
                                          Model model,
                                          Paginate paginate){
        if (name==null)
            name="";
        int totalRecord = this.categoryService.count(name);
        paginate.setTotalCount(totalRecord);

        List<Category> categories = this.categoryService.getAllCategoriesPaginate(name, paginate);
        model.addAttribute("categoryList", categories);
        model.addAttribute("paginate", paginate);
        model.addAttribute("filter", name);
        return "admin/categories/list-all-category";
    }
}
