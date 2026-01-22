package com.example.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.laptopshop.service.UserService;

@Controller
public class UserController {

    // UserService là dependency được inject vào Controller
    private UserService userService;

    // Inject UserService thông qua constructor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/") // url web
    public String getHomePage() {

        String test = this.userService.handleHello();
        return "hello";
    }
}
