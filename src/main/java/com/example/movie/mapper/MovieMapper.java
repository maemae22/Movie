package com.example.movie.mapper;

import com.example.movie.dto.CommentDTO;
import com.example.movie.dto.DailyMovieDTO;
import com.example.movie.dto.MovieDTO;
import com.example.movie.dto.OrderDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface MovieMapper {
    int insertDailyMovie(DailyMovieDTO dailyMovieDTO);
    int insertMovieDetail(MovieDTO movieDTO);
    ArrayList<HashMap<String, Object>> selectDailyMovieCode();
    Integer selectDateInsertChk();
    DailyMovieDTO selectMovieName(Long movie_id);
    DailyMovieDTO selectMovieNameComment(Long movie_id);

    MovieDTO selectMovieNameComment(CommentDTO commentDTO);
}