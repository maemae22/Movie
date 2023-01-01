package com.example.movie.page.controller;

import com.example.movie.api.BoxOfficeApi;
import com.example.movie.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@Slf4j
public class PageController {

    private final BoxOfficeApi boxOfficeApi;
    private final MovieService ms;
    @Autowired
    public PageController(BoxOfficeApi boxOfficeApi, MovieService ms) {
        this.boxOfficeApi = boxOfficeApi;
        this.ms = ms;
    }

    @GetMapping("/")
    public String index() {
        try{
            // 해당 날짜 기준으로 insert 되었는지 확인함. check 시 null 이면 DAILY_BOXOFFICE, MOVIE_DETAIL 테이블에 today-1 날짜 기준으로 insert 된다.
            if(ms.selectDateInsertChk() == null ){
            boxOfficeApi.dailyBoxOffice();  // DAILY_BOXOFFICE 테이블 update
            boxOfficeApi.movieDetail();     // MOVIE_DETAIL 테이블 update
            }
        } catch(Exception e){
            log.info(e.getMessage());
        }

        return "index";
    }

    @GetMapping("/mypage/login")
    public String myLogin() {
        return "mypage/login";
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
