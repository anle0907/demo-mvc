package com.example.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.laptopshop.domain.User;

import com.example.laptopshop.service.UserService;
import org.springframework.ui.Model;

@Controller
public class UserController {

    // UserService là dependency được inject vào Controller
    private final UserService userService;

    // Inject UserService thông qua constructor
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @RequestMapping("/") // url web
    public String getHomePage(Model model) {

        model.addAttribute("anle", "test");
        model.addAttribute("vuavanhdai", "from controller with model");
        return "hello";
    }

    @RequestMapping("/admin/user") // url web //method GET
    public String getInforPage(Model model) {
        model.addAttribute("newUser", new User()); // Object class User o Domain
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create1", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User an) {
        // @ModelAttribute dùng để bind dữ liệu từ form (view)
        // vào object User (biến an) trong Controller

        System.out.println("Run here" + an);
        this.userService.handleSaveUser(an); // method define o service
        return "hello";
    }
}
