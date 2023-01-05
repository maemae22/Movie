package com.example.movie.service;

import com.example.movie.dto.CommentDTO;
import com.example.movie.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CommentService {

    @Autowired
    CommentRepository cr;

    public ArrayList<CommentDTO> selectComment(Long member_id) {
        return cr.selectComment(member_id);
    }

    public String deleteComment(Long id) {
        int result = cr.deleteComment(id);
        if (result == 1) {
            return "success";
        } else {
            return "failed";
        }
    }
}
