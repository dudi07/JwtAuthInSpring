package com.spring.jwt.security.demo.model;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.SigningKeyResolver;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.List;

public class CustomSigningKeyResolver implements SigningKeyResolver {
    private final List<Key> keys;

    public CustomSigningKeyResolver(List<Key> keys) {
        this.keys = keys;
    }

    @Override
    public Key resolveSigningKey(JwsHeader jwsHeader, Claims claims) {
        return keys.get(0);
    }

    @Override
    public Key resolveSigningKey(JwsHeader jwsHeader, String s) {
        return keys.get(0);
    }
}
