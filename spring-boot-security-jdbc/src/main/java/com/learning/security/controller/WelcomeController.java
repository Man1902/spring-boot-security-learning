package com.learning.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @RequestMapping("/")
    public String defaultGreeting() {
        return "Default Greeting";
    }

    @RequestMapping("/user")
    public String userGreeting() {
        return "Hello User";
    }

    @RequestMapping("/admin")
    public String adminGreeting() {
        return "Hello Admin";
    }

    @RequestMapping("/other")
    public String otherGreeting() {
        return "Greeting from Other";
    }
}
