package com.example.movie.repository;

import com.example.movie.dto.MovieDTO;
import com.example.movie.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {

    @Autowired
    MovieMapper mm;

    public List<MovieDTO> selectAllMovie() {
        return mm.selectAllMovie();
    }

    public MovieDTO selectMovieById(long id) {
        return mm.selectMovieById(id);
    }

}
