package com.example.shopscanner_spring_api.api.controller;

import com.example.shopscanner_spring_api.api.model.User;
import com.example.shopscanner_spring_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public User getUser(@RequestParam String nombre, @RequestParam String passw){
        return userService.getUser(nombre,passw);
    }
}
