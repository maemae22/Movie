package com.example.movie.controller;

import com.example.movie.dto.MemberDTO;
import com.example.movie.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Autowired
    MemberService ms;

    @ResponseBody
    @PostMapping("/member/withdrawal")
    public String withdrawal(HttpSession session) {
        MemberDTO member = ms.selectMemberDetail((String) session.getAttribute("nickname"));

        return ms.updateIsMemberStatus(member);
    }
}
