package com.spring.jwt.security.demo.model;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.SigningKeyResolver;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.Key;

public class CustomSigningKeyResolver implements SigningKeyResolver {
    @Override
    public Key resolveSigningKey(JwsHeader jwsHeader, Claims claims) {
        SecretKey secretKey = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS512);
        return secretKey;
    }

    @Override
    public Key resolveSigningKey(JwsHeader jwsHeader, String s) {
        return null;
    }
}
