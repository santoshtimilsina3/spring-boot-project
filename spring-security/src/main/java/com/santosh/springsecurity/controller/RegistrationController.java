package com.santosh.springsecurity.controller;

import com.santosh.springsecurity.entity.User;
import com.santosh.springsecurity.model.UserModel;
import com.santosh.springsecurity.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private UserService userService;

    RegistrationController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel){
    User user = userService.registerUser(userModel);
    }

}
