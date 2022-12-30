package com.example.movie.controller;

import com.example.movie.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BoardController {

    @Autowired
    BoardService bs;


}
