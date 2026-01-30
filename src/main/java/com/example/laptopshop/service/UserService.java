package com.example.laptopshop.service;

import java.util.List;

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

    // Method tìm tất cả User
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    // Method tìm tất cả User bằng email
    public List<User> getAllUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    // Method tìm theo id
    public User getUserById(long id) {
        return this.userRepository.findById(id);
    }

    // Method delete by id
    public void deleteUser(long id) {
        this.userRepository.deleteById(id);
    }

    // Method luu data object
    public User handleSaveUser(User user) {
        User an = this.userRepository.save(user);
        return an;
    }
}
