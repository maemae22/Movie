package com.example.movie.login.controller;

import com.example.movie.dto.MemberDTO;
import com.example.movie.login.service.SignupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
public class SignupController {

    private final SignupService signupService;

    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }

    @GetMapping("/signup")
    public String goSignup() {
        return "signup";
    }

    @PostMapping("/signup")
    @ResponseBody
    public String signup(MemberDTO memberDTO) {
        return signupService.signup(memberDTO);
    }
}
