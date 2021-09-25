package com.learning.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class SpringBootOauth2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOauth2ServerApplication.class, args);
    }

}
