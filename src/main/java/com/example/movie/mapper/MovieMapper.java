package com.example.movie.mapper;

import com.example.movie.dto.DailyMovieDTO;
import com.example.movie.dto.MovieDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface MovieMapper {
    int insertDailyMovie(DailyMovieDTO dailyMovieDTO);
    int insertMovieDetail(MovieDTO movieDTO);
    ArrayList<HashMap<String, Object>> selectDailyMovieCode();
    Integer selectDateInsertChk();
    List<MovieDTO> selectAllMovies();
    MovieDTO selectMovieDetailByMovieCode(int movieCd);
}
