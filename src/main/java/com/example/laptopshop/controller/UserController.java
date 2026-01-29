package com.example.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        List<User> arrUser = this.userService.getAllUserByEmail("gio@gmail.com");
        System.out.println(arrUser);
        model.addAttribute("anle", "test");
        model.addAttribute("vuavanhdai", "from controller with model");
        return "hello";
    }

    @RequestMapping("/admin/user") // url web //method GET
    public String getInforPage(Model model) {
        List<User> users = this.userService.getAllUser();
        model.addAttribute("users1", users);
        return "admin/user/user_table";
    }

    // Show detail user
    @RequestMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {

        User user = userService.getUserById(id);

        if (user == null) {
            return "redirect:/admin/user";
        }

        model.addAttribute("user", user);
        return "admin/user/user_detail";
    }

    @RequestMapping("/admin/user/create")
    public String getCreatePage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    // @ModelAttribute dùng để bind dữ liệu từ form (view)
    // vào object User (biến an) trong Controller
    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User an) {

        this.userService.handleSaveUser(an); // method define o service
        return "redirect:/admin/user";
    }

    // Update
    @RequestMapping("/admin/user/update/{id}") // url
    public String getUpdatePage(Model model, @PathVariable long id) {
        User currentUser = userService.getUserById(id);
        model.addAttribute("newUser", currentUser);
        return "admin/user/user_update"; // view
    }

    @PostMapping("/admin/user/update")
    public String postUpdateUser(Model model, @ModelAttribute("newUser") User newData) {
        User currentUser = userService.getUserById(newData.getId());
        if (currentUser != null) {
            currentUser.setAddress(newData.getAddress());
            currentUser.setFullName(newData.getFullName());
            currentUser.setPhone(newData.getPhone());

            this.userService.handleSaveUser(newData);
        }
        return "redirect:/admin/user";
    }

}
