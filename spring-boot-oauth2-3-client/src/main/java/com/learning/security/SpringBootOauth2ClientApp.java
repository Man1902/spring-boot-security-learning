package com.learning.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
public class SpringBootOauth2ClientApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOauth2ClientApp.class, args);
    }

}
