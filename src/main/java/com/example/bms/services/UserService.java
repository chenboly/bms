package com.example.bms.services;

import com.example.bms.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    int save(User user);
}
