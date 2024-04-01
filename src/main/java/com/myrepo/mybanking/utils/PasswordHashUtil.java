package com.myrepo.mybanking.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordHashUtil {

    private static final int ITERATIONS = 64000;

//    @Value("${salt.length}")
    private int SALT_LENGTH = 10;

//    @Value("${secret}")
    private String secretCode = "secret1";

    public PasswordEncoder getEncoder(String secretCode) {
        return new Pbkdf2PasswordEncoder(
                secretCode,
                SALT_LENGTH,
                ITERATIONS,
                Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA512
        );
    }

    public String createHash(String password) {
        return getEncoder(secretCode).encode(password);
    }

    public boolean verifyHash(String hash, String password, String secretCode) {
        return getEncoder(secretCode).matches(
                password,
                hash
        );
    }
}
