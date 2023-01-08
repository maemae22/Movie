package com.example.movie.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/movie")
    public String movieList() {
        return "movie";
    }
}
