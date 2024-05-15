package com.spring.jwt.security.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ValidateAuthRequest {
    private String token;
    private String applicationId;
}
