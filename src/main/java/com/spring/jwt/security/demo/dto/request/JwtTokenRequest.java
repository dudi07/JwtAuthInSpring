package com.spring.jwt.security.demo.dto.request;

import lombok.Data;

@Data
public class JwtTokenRequest {
    String email;
    String password;
    String applicationId;
}
