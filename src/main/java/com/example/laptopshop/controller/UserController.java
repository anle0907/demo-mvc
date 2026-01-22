package com.example.laptopshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.laptopshop.service.UserService;

// @Controller
// public class UserController {

// @RequestMapping("/")
// public String getHomePage() {
// return "home from controller";
// }
// }

@RestController
public class UserController {

    // UserService là dependency được inject vào Controller
    private UserService userService;

    // Inject UserService thông qua constructor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String getHomePage() {
        return this.userService.handleHello();
    }
}