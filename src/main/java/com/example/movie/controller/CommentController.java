package com.example.movie.controller;

import com.example.movie.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CommentController {

    @Autowired
    CommentService cs;


}
