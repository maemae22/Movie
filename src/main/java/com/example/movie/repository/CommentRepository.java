package com.example.movie.repository;

import com.example.movie.dto.CommentDTO;
import com.example.movie.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class CommentRepository {

    @Autowired
    CommentMapper cm;

    public ArrayList<CommentDTO> selectComment(Long member_id) {
        return cm.selectComment(member_id);
    }

    public ArrayList<CommentDTO> selectMovieId(Long member_id) {
        return cm.selectMovieId(member_id);
    }

    public int deleteComment(Long id) {
        return cm.deleteComment(id);
    }
}
