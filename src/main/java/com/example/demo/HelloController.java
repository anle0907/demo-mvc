package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello() {
        return "Hello World with AnJr Brazzilian!";
    }

    @GetMapping("/user")
    public String userPage() {
        return "Only User can access!";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "Only Admin can access!";
    }
}
