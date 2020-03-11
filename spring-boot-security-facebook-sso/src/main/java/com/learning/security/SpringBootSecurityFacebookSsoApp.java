package com.learning.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
@EnableOAuth2Sso
public class SpringBootSecurityFacebookSsoApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityFacebookSsoApp.class, args);
    }

}
