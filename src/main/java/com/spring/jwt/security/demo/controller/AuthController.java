package com.spring.jwt.security.demo.controller;

import com.spring.jwt.security.demo.dto.request.JwtTokenRequest;
import com.spring.jwt.security.demo.dto.response.GenerateAuthResponse;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationService authenticateService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    @PostMapping("/generate")
    public ResponseEntity<GenerateAuthResponse> generateToken(@RequestBody JwtTokenRequest jwtTokenRequest){
        log.info("Generate token for this request {}" , jwtTokenRequest);
        this.doAuthenticate(jwtTokenRequest.getEmail(), jwtTokenRequest.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(jwtTokenRequest.getEmail());
        GenerateAuthResponse token = authenticateService.generateToken(userDetails, jwtTokenRequest.getApplicationId());
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
