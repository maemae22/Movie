package com.example.movie.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminPageController {

    @GetMapping()
    public String login() {
        return "admin/login";
    }

    @GetMapping("/index")
    public String index() {
        return "admin/index";
    }

    @GetMapping("/memberList")
    public String memberList() {
        return "admin/memberlist";
    }

    @GetMapping("/theaterList")
    public String theaterList() {
        return "admin/theaterlist";
    }

    @GetMapping("/addTheater")
    public String addTheater() {
        return "admin/addtheater";
    }
}
