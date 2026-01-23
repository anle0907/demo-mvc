package com.example.laptopshop.domain;

public class User {

    // field
    private long id;
    private String email;
    private String password;
    private String fullName;
    private String address;
    private String phone;

    // contructor
    public User(long id, String email, String password, String fullName, String address, String phone) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
    }

    // getter
    public long getID() {
        return this.id = id;
    }

    public String getEmail() {
        return this.email = email;
    }

    public String getPass() {
        return this.password = password;
    }

    public String getFullName() {
        return this.fullName = fullName;
    }

    public String getAddress() {
        return this.address = address;
    }

    public String getPhone() {
        return this.phone = phone;
    }

    // setter
    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String password) {
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
        return "User infomation  -ID: " + this.getID() + " -Email: " + this.getEmail() + " -FullName: "
                + this.getFullName() + " -Address: " + this.getAddress() + " -Phone: " + this.getPhone();
    }

}
