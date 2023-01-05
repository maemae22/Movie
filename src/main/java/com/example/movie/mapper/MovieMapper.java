package com.example.movie.mapper;

import com.example.movie.dto.CommentDTO;
import com.example.movie.dto.MovieDTO;
import com.example.movie.dto.OrderDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MovieMapper {
    MovieDTO selectMovieName(OrderDTO orderDTO);

    MovieDTO selectMovieNameComment(CommentDTO commentDTO);
}