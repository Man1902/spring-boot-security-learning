package com.learning.security.ldap.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @RequestMapping("/")
    public String defaultGreeting() {
        return "Default Greeting";
    }

}
