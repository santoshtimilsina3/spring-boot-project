package com.minute.springboot.web.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

    public boolean validation(String name, String password){
       return name.equals("superadmin")&& password.equals("superadmin123");
    }
}
