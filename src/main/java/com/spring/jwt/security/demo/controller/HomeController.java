package com.spring.jwt.security.demo.controller;

import com.spring.jwt.security.demo.model.User;
import com.spring.jwt.security.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {
//    http:localhost:8081/home/user
    private final UserService userService;
    @GetMapping("/user")
    public ResponseEntity<User>getUser(){
        System.out.println("Getting users");

        return new ResponseEntity<>(userService.getUser(), HttpStatus.OK);
    }

}
