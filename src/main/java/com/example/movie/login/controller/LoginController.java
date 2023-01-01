package com.example.movie.login.controller;

import com.example.movie.dto.MemberDTO;
import com.example.movie.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
@Slf4j
@Controller
public class LoginController {
    @Autowired
    MemberService ms;

    @PostMapping("/login")
    public String login(MemberDTO memberDTO, HttpSession session) {
        MemberDTO member = ms.selectLogin(memberDTO);
        session.setAttribute("email", member.getEmail());
        return "redirect:/mypage";
    }
}
