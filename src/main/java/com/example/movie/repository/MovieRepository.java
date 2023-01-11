package com.example.movie.repository;

import com.example.movie.dto.DailyMovieDTO;

import com.example.movie.dto.MovieDTO;
import com.example.movie.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    private final MovieMapper mm;
    @Autowired
    public MovieRepository(MovieMapper mm) {
        this.mm = mm;
    }
    public int insertDailyMovie(DailyMovieDTO dailyMovieDTO){
        return mm.insertDailyMovie(dailyMovieDTO);
    }
    public int insertMovieDetail(MovieDTO movieDTO){
        return mm.insertMovieDetail(movieDTO);
    }
    public ArrayList<HashMap<String, Object>> selectDailyMovieCode(){
        return mm.selectDailyMovieCode();
    }
    public Integer selectDateInsertChk(){
        return mm.selectDateInsertChk();
    }
    public List<MovieDTO> selectAllMovies() { return mm.selectAllMovies(); }
    public MovieDTO selectMovieDetailByMovieCode(int movieCd) { return mm.selectMovieDetailByMovieCode(movieCd); }
}
