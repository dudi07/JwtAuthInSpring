package com.spring.jwt.security.demo.service.impl;

import com.spring.jwt.security.demo.model.User;
import com.spring.jwt.security.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {


    public User getUser(){
        User user = new User();
        user.setEmail("sanjay@airtel.com");
        user.setName("Sanjay");
        user.setUserId(UUID.randomUUID().toString());


        return user;
    }
}
