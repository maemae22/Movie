package com.example.movie.mapper;

import com.example.movie.dto.DailyMovieDTO;
import com.example.movie.dto.MovieDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface MovieMapper {
    int insertDailyMovie(DailyMovieDTO dailyMovieDTO);
    int insertMovieDetail(MovieDTO movieDTO);
    ArrayList<HashMap<String, Object>> selectDailyMovieCode();
    Integer selectDateInsertChk();
    ArrayList<MovieDTO> selectMovieDtMovieNmDirNm();
    Integer updateMvDtImgAndSummary(MovieDTO movieDTO);
    ArrayList<HashMap<String,String>> selectDailyRank();
}
