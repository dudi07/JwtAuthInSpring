package com.spring.jwt.security.demo.controller;

import com.spring.jwt.security.demo.dto.request.JwtTokenRequest;
import com.spring.jwt.security.demo.dto.response.GenerateAuthResponse;
import com.spring.jwt.security.demo.model.User;
import com.spring.jwt.security.demo.service.AuthenticationService;
import com.spring.jwt.security.demo.service.UserService;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/auth")
@RequiredArgsConstructor
public class HomeController {
//    http:localhost:8081/home/user
    private final UserService userService;
    private final AuthenticationService authenticateService;
    private final AuthenticationManager authenticationManager;

    private UserDetailsService userDetailsService;
    @GetMapping("/user")
    public ResponseEntity<User>getUser(){
        System.out.println("Getting users");

        return new ResponseEntity<>(userService.getUser(), HttpStatus.OK);
    }


    @PostMapping("/generate")
    public ResponseEntity<GenerateAuthResponse>generateToken(@RequestBody JwtTokenRequest jwtTokenRequest){
        this.doAuthenticate(jwtTokenRequest.getEmail(), jwtTokenRequest.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(jwtTokenRequest.getEmail());
        GenerateAuthResponse token = authenticateService.generateToken(userDetails);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            authenticationManager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

}
