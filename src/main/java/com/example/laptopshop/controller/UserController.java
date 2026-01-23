package com.example.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.laptopshop.service.UserService;
import org.springframework.ui.Model;

@Controller
public class UserController {

    // UserService là dependency được inject vào Controller
    private UserService userService;

    // Inject UserService thông qua constructor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/") // url web
    public String getHomePage(Model model) {

        String test = this.userService.handleHello();
        model.addAttribute("anle", test);
        model.addAttribute("vuavanhdai", "from controller with model");
        return "hello";
    }

    @RequestMapping("/admin/user") // url web
    public String getInforPage(Model model) {

        return "admin/user/create";
    }
}
