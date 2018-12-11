package com.example.bms.controllers.restcontrollers;

import com.example.bms.models.User;
import com.example.bms.services.UserService;
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
}
