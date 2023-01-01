package com.example.movie.login.controller;

import com.example.movie.login.dto.MemberDTO;
import com.example.movie.login.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/member")
public class LoginController {

    private final LoginService loginService;


    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @GetMapping("/login")
    public String goLogin() {
        return "login";

    }

    @PostMapping("/login")
    public String login( MemberDTO memberDTO) {
                loginService.loginUserIdPassword(memberDTO);
        log.info("memberDTO = {}", memberDTO.toString());
    }
        return "redirect:/";
}
