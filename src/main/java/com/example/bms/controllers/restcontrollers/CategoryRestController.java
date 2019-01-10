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
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getOneCategoryById(@PathVariable("id") Integer id){
        Map<String, Object> respone = new HashMap<>();
        Category category = this.categoryService.getOneCategoryById(id);
        respone.put("data", category);
        respone.put("message", "Get Category Successfully");
        respone.put("status", true);
        return new ResponseEntity<>(respone, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllCategories(String name){
        List<Category> categories = this.categoryService.getAllCategories(name);
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

    @PutMapping("")
    public ResponseEntity<Map<String, Object>> update (@RequestBody Category category){
        Map<String, Object> respone = new HashMap<>();
        boolean status = this.categoryService.update(category);
        if(status){
            respone.put("message", "Update category successfully!!");
            respone.put("status", true);
        }
        return new ResponseEntity<>(respone, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> Delete (@PathVariable Integer id){
        Map<String, Object> respone = new HashMap<>();
        Integer status = this.categoryService.delete(id);
        if (status > 0){
            respone.put("message", "delete category success!!");
            respone.put("status", true);
        }
        return new ResponseEntity<>(respone, HttpStatus.OK);
    }
}
