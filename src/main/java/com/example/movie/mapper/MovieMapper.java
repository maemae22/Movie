package com.example.movie.mapper;

import com.example.movie.dto.MovieDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MovieMapper {
    List<MovieDTO> selectAllMovie();
    MovieDTO selectMovieById(long id);
}