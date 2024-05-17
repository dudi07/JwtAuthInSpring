package com.spring.jwt.security.demo.model;

import java.security.Key;

public class KeyForUser implements Key {

    @Override
    public String getAlgorithm() {
        return null;
    }

    @Override
    public String getFormat() {
        return null;
    }

    @Override
    public byte[] getEncoded() {
        return new byte[0];
    }
}
