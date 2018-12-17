package com.example.bms.controllers.restcontrollers;

import com.example.bms.models.Category;
import com.example.bms.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryRestController {

    private CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories = this.categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Map<String, Object>> save(@RequestBody @Valid Category category){
        Map<String, Object> response = new HashMap<>();
        boolean status = this.categoryService.save(category);
        if(status){
            response.put("message", "Save Category Successfully!!!");
            response.put("status", true);
            return ResponseEntity.ok(response);
        }
        else {
            response.put("message", "Save Category Failed!!");
            response.put("status", false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }
}
