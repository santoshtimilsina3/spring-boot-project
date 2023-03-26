package com.santosh.springsecurity.service;

import com.santosh.springsecurity.entity.User;
import com.santosh.springsecurity.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User registerUser(UserModel userModel);
}
