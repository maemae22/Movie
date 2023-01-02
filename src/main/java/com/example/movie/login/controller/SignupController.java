package com.example.movie.login.controller;

import com.example.movie.login.dto.MemberDTO;
import com.example.movie.login.service.SignupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class SignupController {

    private final SignupService signupService;

    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }

    //    private final
    @GetMapping("/signup")
    public String goSignup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(MemberDTO memberDTO) {
        return signupService.signup(memberDTO);
    }
}
