package com.example.movie.login.controller;

import com.example.movie.login.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class LoginController {

    @GetMapping("/login")
    public String goLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(MemberDTO memberDTO) {
        return
    }
}
