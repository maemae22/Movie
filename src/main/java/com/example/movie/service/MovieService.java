package com.example.movie.service;

import com.example.movie.dto.DailyMovieDTO;
import com.example.movie.dto.MovieDTO;
import com.example.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MovieService {

    private MovieRepository mr;
    @Autowired
    public MovieService(MovieRepository mr) {
        this.mr = mr;
    }

    public int insertDailyMovie(DailyMovieDTO dailyMovieDTO){
        return mr.insertDailyMovie(dailyMovieDTO);
    }
    public int insertMovieDetail(MovieDTO movieDTO){
        return mr.insertMovieDetail(movieDTO);
    }
    public ArrayList<HashMap<String, Object>> selectDailyMovieCode(){
        return mr.selectDailyMovieCode();
    }
    public Integer selectDateInsertChk(){
        return mr.selectDateInsertChk();
    }
}
