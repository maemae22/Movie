package com.example.movie.controller;

import com.example.movie.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class TheaterController {
    @Autowired
    TheaterService ts;

    @GetMapping("/theater/detail/{id}")
    public String theaterDetail(@PathVariable Long id) {
        return "mypage/map";
    }
}
