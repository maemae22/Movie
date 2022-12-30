package com.example.movie.controller;

import com.example.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MovieController {

    @Autowired
    MovieService ms;


}
