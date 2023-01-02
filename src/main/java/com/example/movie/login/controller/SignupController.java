package com.example.movie.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class SignupController {
//    private final
    @GetMapping("/signup")
    public String goSignup() {
        return "signup";
    }
}
