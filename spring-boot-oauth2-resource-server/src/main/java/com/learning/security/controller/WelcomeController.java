package com.learning.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @RequestMapping("/secured")
    public String secured() {
        return "Secured Resource";
    }

    @RequestMapping("/user")
    @PreAuthorize("hasAnyRole('ROLE_USER' , 'ROLE_ADMIN')")
    public String userGreeting() {
        return "Hello User";
    }

    @RequestMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminGreeting() {
        return "Hello Admin";
    }

    @RequestMapping("/edit")
    @PreAuthorize("hasAuthority('CAN_EDIT')")
    public String edit() {
        return "Edit Resource";
    }

    @RequestMapping("/write")
    @PreAuthorize("hasAuthority('CAN_WRITE')")
    public String write() {
        return "Write Resource";
    }

    @RequestMapping("/read")
    @PreAuthorize("hasAuthority('CAN_READ')")
    public String read() {
        return "Read Resource";
    }
}
