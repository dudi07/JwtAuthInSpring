package com.spring.jwt.security.demo.controller;

import com.spring.jwt.security.demo.dto.request.JwtTokenRequest;
import com.spring.jwt.security.demo.dto.response.GenerateAuthResponse;
import com.spring.jwt.security.demo.model.User;
import com.spring.jwt.security.demo.service.AuthenticationService;
import com.spring.jwt.security.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
@Slf4j
public class HomeController {
//    http:localhost:8081/home/user
    private final UserService userService;
    @GetMapping("/user")
    public ResponseEntity<User>getUser(){
        System.out.println("Getting users");

        return new ResponseEntity<>(userService.getUser(), HttpStatus.OK);
    }




}
