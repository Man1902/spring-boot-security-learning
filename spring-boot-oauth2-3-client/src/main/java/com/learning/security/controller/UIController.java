package com.learning.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIController {
    @RequestMapping(value = "/")
    public String loadUI() {
        return "home";
    }

    @RequestMapping(value = "/secure")
    public String loadSecuredUI() {
        return "secure";
    }
}
