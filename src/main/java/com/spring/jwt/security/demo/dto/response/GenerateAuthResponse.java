package com.spring.jwt.security.demo.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GenerateAuthResponse {
    private String token;
    private LocalDateTime expiryTime;
}
