package com.example.demo.demo;

import lombok.Getter;

@Getter
public class User {
    private String id;
    private String password;
    private String name;

    public User(String password) {
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
