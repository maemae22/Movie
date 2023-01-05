package com.example.movie.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "mypage";
    }

    @GetMapping("/member/withdrawal")
    public String withdraw() {
        return "mypage/withdrawal";
    }

    @GetMapping("/theater/detail")
    public String theaterDetail() {
        return "map";
    }
}
