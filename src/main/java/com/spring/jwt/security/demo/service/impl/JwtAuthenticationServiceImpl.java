package com.spring.jwt.security.demo.service.impl;

import com.spring.jwt.security.demo.auth.JWTHelper;
import com.spring.jwt.security.demo.dto.response.GenerateAuthResponse;
import com.spring.jwt.security.demo.dto.response.ValidateAuthResponse;
import com.spring.jwt.security.demo.dto.request.ValidateAuthRequest;
import com.spring.jwt.security.demo.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationServiceImpl implements AuthenticationService {

    private final JWTHelper jwtHelper;
    @Override
    public GenerateAuthResponse generateToken(UserDetails user) {
        log.info("Generating jwt token for {}", user);
        var token =jwtHelper.generateToken(user);
        return prepareTokenResponse(token, jwtHelper.getExpirationDateFromToken(token)
                .toInstant().
                atZone(ZoneId.systemDefault()).toLocalDateTime());
    }

    @Override
    public ValidateAuthResponse validateToken(ValidateAuthRequest request) {
        return null;
    }
    GenerateAuthResponse prepareTokenResponse(String token, LocalDateTime localDateTime){
        return GenerateAuthResponse
                .builder()
                .expiryTime(localDateTime)
                .token(token)
                .build();
    }
}