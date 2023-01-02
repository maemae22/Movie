package com.example.movie.page.controller;

import com.example.movie.dto.MemberDTO;
import com.example.movie.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Slf4j
@RequestMapping("/mypage")
@Controller
public class MyPageController {
    @Autowired
    MemberService ms;

    @GetMapping
    public String myPage(HttpSession session, Model model) {
        MemberDTO memberDTO = ms.selectMemberDetail((String)session.getAttribute("email"));
        model.addAttribute("memberDTO", memberDTO);
        return "mypage/myPage";
    }

    @GetMapping("/user-detail")
    public String userDetail(HttpSession session, Model model) {
        MemberDTO memberDTO = ms.selectMemberDetail((String)session.getAttribute("email"));
        model.addAttribute("memberDTO", memberDTO);
        return "/mypage/user-detail";
    }

    @GetMapping("/user-edit/name")
    public String userEditName(HttpSession session, Model model) {
        MemberDTO memberDTO = ms.selectMemberDetail((String)session.getAttribute("email"));
        model.addAttribute("memberDTO", memberDTO);
        return "/mypage/user-edit-name";
    }
    @ResponseBody
    @PostMapping("/user-edit/name")
    public String updateName(MemberDTO memberDTO, HttpSession session) {
        String email = (String) session.getAttribute("email");
        memberDTO.setEmail(email);
        return ms.updateMemberName(memberDTO);
    }

    @GetMapping("/user-edit/password")
    public String userEditPassword(HttpSession session, Model model) {
        MemberDTO memberDTO = ms.selectMemberDetail((String)session.getAttribute("email"));
        model.addAttribute("memberDTO", memberDTO);
        return "/mypage/user-edit-password";
    }

    @ResponseBody
    @PostMapping("/user-edit/password")
    public String updatePassword(MemberDTO memberDTO, HttpSession session) {
        String email = (String) session.getAttribute("email");
        memberDTO.setEmail(email);
        return ms.updateMemberPassword(memberDTO);
    }

    @GetMapping("/user-comment")
    public String userComment(HttpSession session, Model model) {
        MemberDTO memberDTO = ms.selectMemberDetail((String)session.getAttribute("email"));
        model.addAttribute("memberDTO", memberDTO);
        return "/mypage/user-comment";
    }

    @GetMapping("/user-order")
    public String userOrder(HttpSession session, Model model) {
        MemberDTO memberDTO = ms.selectMemberDetail((String)session.getAttribute("email"));
        model.addAttribute("memberDTO", memberDTO);
        return "/mypage/user-order";
    }
}
