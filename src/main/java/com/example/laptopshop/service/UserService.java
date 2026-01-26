package com.example.laptopshop.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String handleHello() {
        return "Hello from service";
    }

    public String showInfo() {
        return "user";
    }
}
