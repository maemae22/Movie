package com.example.movie.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/movie")
    public String movieList() {
        return "movie";
    }

    @GetMapping("/movie_detail/{movieId}")
    public String movieDetail(@PathVariable long movieId) {
        return "movie_detail";
    }

}
