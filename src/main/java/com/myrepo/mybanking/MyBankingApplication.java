package com.myrepo.mybanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MyBankingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBankingApplication.class, args);
    }

}
