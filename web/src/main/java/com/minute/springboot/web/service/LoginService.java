package com.minute.springboot.web.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

    public boolean validation(String name, String password){
       return name.equals("in28Minutes")&& password.equals("manu");
    }
}
