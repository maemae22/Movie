package com.example.movie.repository;

import com.example.movie.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepository {

    @Autowired
    BoardMapper bm;


}
