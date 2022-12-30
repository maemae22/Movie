package com.example.movie.repository;

import com.example.movie.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository {

    @Autowired
    CommentMapper cm;


}
