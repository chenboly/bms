package com.example.bms.controllers.restcontrollers;

import com.example.bms.models.User;
import com.example.bms.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();

    }

    @PostMapping("")
    public String save(@RequestBody User user){
        int status = this.userService.save(user);
        if(status>0){
            return "Save user successfully!!";
        }
        return "Save user failed!!";
    }

    @PutMapping("")
    public ResponseEntity<String> update(@RequestBody User user){
        int status = this.userService.update(user);
        if (status>0){
            return ResponseEntity.ok("Update User Successfully!!");
        }
        return new ResponseEntity<>("Update User Failed!!!", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id){
        int status = this.userService.delete(id);
        if(status>0){
            return ResponseEntity.ok("Delete User Successfully!!");
        }
        return new ResponseEntity<>("Delete User Failed!!!", HttpStatus.NOT_FOUND);
    }
}
