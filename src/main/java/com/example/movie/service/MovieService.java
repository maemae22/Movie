package com.example.movie.service;

import com.example.movie.dto.MovieDTO;
import com.example.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository mr;

    public List<MovieDTO> selectAllMovie() {
        return mr.selectAllMovie();
    }

    public MovieDTO selectMovieById(long id) {
        return mr.selectMovieById(id);
    }
}
