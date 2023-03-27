package com.spring.security.service;

import com.spring.security.entity.User;
import com.spring.security.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
