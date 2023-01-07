package com.example.movie.repository;

import com.example.movie.dto.CommentDTO;
import com.example.movie.dto.DailyMovieDTO;

import com.example.movie.dto.MovieDTO;
import com.example.movie.dto.OrderDTO;
import com.example.movie.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class MovieRepository {

    @Autowired
    MovieMapper mm;

//    public MovieDTO selectMovieName(OrderDTO orderDTO) {
//        return mm.selectMovieName(orderDTO);
//    }

    public MovieDTO selectMovieNameComment(CommentDTO commentDTO) {
        return mm.selectMovieNameComment(commentDTO);
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

    public DailyMovieDTO selectMovieName(Long movie_id) {
        return mm.selectMovieName(movie_id);
    }
    public DailyMovieDTO selectMovieNameComment(Long movie_id) {
        return mm.selectMovieNameComment(movie_id);
    }
}
