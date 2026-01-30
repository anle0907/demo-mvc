package com.example.laptopshop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // annotation
// @Table(name = "nguoi_dung") thay đổi tên table

public class User {

    @Id // annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng giá trị ID
    private long id;

    private String email;
    private String password;
    private String fullName;
    private String address;
    private String phone;

    // getter
    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    // setter
    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User infomation -ID: " + this.getId() + " -Email: " + this.getEmail() + " -FullName: "
                + this.getFullName() + " -Address: " + this.getAddress() + " -Phone: " + this.getPhone();
    }
}
