package com.santosh.springsecurity.service;

import com.santosh.springsecurity.entity.User;
import com.santosh.springsecurity.model.UserModel;
import com.santosh.springsecurity.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(UserModel userModel) {
        User user = new User();
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setEmail(userModel.getEmail());
        user.setRole("USER");
        user.setPassword(userModel.getPassword());
        return user;
    }
}
