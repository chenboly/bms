package com.example.bms.services.impl;

import com.example.bms.models.User;
import com.example.bms.repositories.UserRepository;
import com.example.bms.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.getAllUsers();
    }

    @Override
    public int save(User user) {
        return this.userRepository.save(user);
    }
}
