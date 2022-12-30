package com.example.movie.repository;

import com.example.movie.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

    @Autowired
    MovieMapper mm;


}
