package com.example.laptopshop.service;

import org.springframework.stereotype.Service;

import com.example.laptopshop.domain.User;
import com.example.laptopshop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    // constructor di repository
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String handleHello() {
        return "Hello from service";
    }

    public String showInfo() {
        return "user";
    }

    public User handleSaveUser(User user) {
        User an = this.userRepository.save(user);
        return an;
    }
}
