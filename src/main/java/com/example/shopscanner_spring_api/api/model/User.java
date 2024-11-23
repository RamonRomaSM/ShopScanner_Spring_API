package com.example.shopscanner_spring_api.api.model;

public class User {
    private String userId;
    private String userName;
    private String password;
    private String email;//TODO: desarrollar la funcionalidad del email

    public User(String userId, String userName, String password, String email) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

}
