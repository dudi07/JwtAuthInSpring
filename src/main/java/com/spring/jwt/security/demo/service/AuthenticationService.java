package com.spring.jwt.security.demo.service;

import com.spring.jwt.security.demo.dto.response.GenerateAuthResponse;
import com.spring.jwt.security.demo.dto.response.ValidateAuthResponse;
import com.spring.jwt.security.demo.dto.request.ValidateAuthRequest;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {
    GenerateAuthResponse generateToken(UserDetails userDetails, String applicationId);
    ValidateAuthResponse validateToken(ValidateAuthRequest request);
}
