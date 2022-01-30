package com.example.trinit;

public class user {
    String name;
    String role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public user() {
    }

    public user(String name, String role, String email) {
        this.email=email;
        this.name=name;
        this.role=role;

    }
}
