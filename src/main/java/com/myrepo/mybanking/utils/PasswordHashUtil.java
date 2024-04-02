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

//    @Value("${secret.code}")
    private String SECRET_CODE = "secret1";

    public PasswordEncoder getEncoder() {
        return new Pbkdf2PasswordEncoder(
                SECRET_CODE,
                SALT_LENGTH,
                ITERATIONS,
                Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA512
        );
    }

    public String createHash(String password) {
        return getEncoder().encode(password);
    }

    public boolean verifyHash(String hash, String password) {

        return getEncoder().matches(password,hash);
    }
}
