package com.example.movie.repository;

import com.example.movie.dto.CommentDTO;
import com.example.movie.dto.MovieDTO;
import com.example.movie.dto.OrderDTO;
import com.example.movie.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

    @Autowired
    MovieMapper mm;

    public MovieDTO selectMovieName(OrderDTO orderDTO) {
        return mm.selectMovieName(orderDTO);
    }

    public MovieDTO selectMovieNameComment(CommentDTO commentDTO) {
        return mm.selectMovieNameComment(commentDTO);
    }

}
