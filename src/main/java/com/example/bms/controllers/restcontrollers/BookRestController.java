package com.example.bms.controllers.restcontrollers;

import com.example.bms.models.Book;
import com.example.bms.services.BookServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/books")
public class BookRestController {
    private BookServices bookServices;

    public BookRestController(BookServices bookServices) {
        this.bookServices = bookServices;
    }

    @GetMapping("")
    public ResponseEntity<Map<String, Object>> getAllBooks(){
        Map<String, Object> response = new HashMap<>();
        List<Book> books = this.bookServices.getAllBooks();
        if(books.size() > 0){
            response.put("status", true);
            response.put("message", "Get Book Successfully!!");
            response.put("data", books);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else {
            response.put("status", false);
            response.put("message", "Get Book Not Found!!");
            response.put("data", books);
            response.put("version", "V1");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }


}
