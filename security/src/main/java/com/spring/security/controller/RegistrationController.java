package com.spring.security.controller;


import com.spring.security.entity.User;
import com.spring.security.event.RegistrationCompleteEvent;
import com.spring.security.model.UserModel;
import com.spring.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel) {
        User user = userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(user, "url"));
        return "Success";
    }

}
