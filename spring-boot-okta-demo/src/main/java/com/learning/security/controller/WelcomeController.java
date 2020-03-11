package com.learning.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class WelcomeController {
    @RequestMapping(value = "/")
    public String loadUI(Principal principal) {
        return "Welcome User ! Your email address is : " + principal.getName();
    }

    @RequestMapping(value = "/secure1")
    public String secure1(Principal principal) {
        return "secure1 resource. (email : " + principal.getName();
    }

    @RequestMapping(value = "/secure2")
    public String secure2(Principal principal) {
        return "secure2 resource. (email : " + principal.getName();
    }
}
