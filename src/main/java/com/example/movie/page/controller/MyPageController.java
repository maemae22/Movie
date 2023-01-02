package com.example.movie.page.controller;

import com.example.movie.dto.MemberDTO;
import com.example.movie.dto.OrderDTO;
import com.example.movie.service.MemberService;
import com.example.movie.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Slf4j
@RequestMapping("/member")
@Controller
public class MyPageController {
    @Autowired
    MemberService ms;

    @Autowired
    OrderService os;

    @GetMapping
    public String myPage(HttpSession session, Model model) {
        MemberDTO memberDTO = ms.selectMemberDetail((MemberDTO)session.getAttribute("member"));
        ArrayList<OrderDTO> orderList = os.selectOrderByMember(memberDTO.getId());
        OrderDTO order = os.selectOrderById(memberDTO.getId());
        model.addAttribute("memberDTO", memberDTO);
        model.addAttribute("orderList", orderList);
        model.addAttribute("recentOrder", order);
        return "mypage/myPage";
    }

    @GetMapping("/user-detail")
    public String userDetail(HttpSession session, Model model) {
        MemberDTO memberDTO = ms.selectMemberDetail((MemberDTO)session.getAttribute("member"));
        model.addAttribute("memberDTO", memberDTO);
        return "/mypage/user-detail";
    }

    @GetMapping("/user-edit/name")
    public String userEditName(HttpSession session, Model model) {
        MemberDTO memberDTO = ms.selectMemberDetail((MemberDTO)session.getAttribute("member"));
        model.addAttribute("memberDTO", memberDTO);
        return "/mypage/user-edit-name";
    }
    @ResponseBody
    @PostMapping("/user-edit/name")
    public String updateName(MemberDTO memberDTO, HttpSession session) {
        MemberDTO member = (MemberDTO) session.getAttribute("member");
        member.setName(memberDTO.getName());
        return ms.updateMemberName(member);
    }

    @GetMapping("/user-edit/password")
    public String userEditPassword(HttpSession session, Model model) {
        MemberDTO memberDTO = ms.selectMemberDetail((MemberDTO)session.getAttribute("member"));
        model.addAttribute("memberDTO", memberDTO);
        return "/mypage/user-edit-password";
    }

    @ResponseBody
    @PostMapping("/user-edit/password")
    public String updatePassword(MemberDTO memberDTO, HttpSession session) {
        MemberDTO member = (MemberDTO) session.getAttribute("member");
        member.setPassword(memberDTO.getPassword());
        return ms.updateMemberPassword(member);
    }

    @GetMapping("/user-comment")
    public String userComment(HttpSession session, Model model) {
        MemberDTO memberDTO = ms.selectMemberDetail((MemberDTO)session.getAttribute("member"));
        model.addAttribute("memberDTO", memberDTO);
        return "/mypage/user-comment";
    }

    @GetMapping("/user-order")
    public String userOrder(HttpSession session, Model model) {
        MemberDTO memberDTO = ms.selectMemberDetail((MemberDTO)session.getAttribute("member"));
        ArrayList<OrderDTO> orderList = os.selectOrderByMember(memberDTO.getId());
        ArrayList<OrderDTO> cancelList = os.selectCancelOrder(memberDTO.getId());
        model.addAttribute("memberDTO", memberDTO);
        model.addAttribute("orderList", orderList);
        model.addAttribute("cancelList", cancelList);
        return "/mypage/user-order";
    }
}
