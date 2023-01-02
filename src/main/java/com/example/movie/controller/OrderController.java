package com.example.movie.controller;

import com.example.movie.dto.MemberDTO;
import com.example.movie.dto.OrderDTO;
import com.example.movie.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class OrderController {

    @Autowired
    OrderService os;

    @GetMapping("/member/user-order/findByList")
    public ArrayList<OrderDTO> selectOrderByMember(HttpSession session, Model model) {
        MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
        ArrayList<OrderDTO> orderList = os.selectOrderByMember(memberDTO.getId());
        model.addAttribute("orderDTO", orderList);
        return orderList;
    }
}
