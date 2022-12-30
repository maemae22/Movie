package com.example.movie.controller;

import com.example.movie.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    @Autowired
    MemberService ms;


}
