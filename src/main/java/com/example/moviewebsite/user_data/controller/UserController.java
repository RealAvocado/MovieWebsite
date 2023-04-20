package com.example.moviewebsite.user_data.controller;


import com.example.moviewebsite.user_data.dto.LoginFormData;
import com.example.moviewebsite.user_data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("login")
    public String login(@RequestBody LoginFormData loginFormData){
        return userService.Login(loginFormData);
    }
}
