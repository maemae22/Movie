package com.example.movie.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/myPage")
@Controller
public class MyPageController {

    @GetMapping
    public String myPage() {
        return "/mypage/mypage";
    }

    @GetMapping("/user-detail")
    public String userDetail() {
        return "/mypage/user-detail";
    }

    @GetMapping("/user-comment")
    public String userComment() {
        return "/mypage/user-comment";
    }

    @GetMapping("/user-order")
    public String userOrder() {
        return "/mypage/user-order";
    }
}
