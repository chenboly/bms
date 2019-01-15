package com.example.bms.controllers;

import com.example.bms.models.Author;
import com.example.bms.models.Book;
import com.example.bms.services.AuthorServices;
import com.example.bms.services.CategoryService;
import com.example.bms.services.impl.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/books")
public class BookController {

    @Autowired
    private FileUploadService fileUploadService;
    @Autowired
    private CategoryService categoryService;
    private AuthorServices authorServices;

    public BookController(AuthorServices authorServices) {
        this.authorServices = authorServices;
    }

    public String showAllBooks(){
        return "";
    }

    @GetMapping("/add")
    public String showAddBookForm(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("authors", this.authorServices.getAllAuthors());
        model.addAttribute("categories", this.categoryService.getAllCategories(""));
        return "admin/books/add-book";
    }

    @PostMapping("/add/submit")
    public String saveBook(Book book, @RequestParam("cover") MultipartFile file){
        System.out.println(file);
        System.out.println(book);
        return "redirect:/admin/books/add";
    }
}
