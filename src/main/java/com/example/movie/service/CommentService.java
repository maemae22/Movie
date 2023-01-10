package com.example.movie.service;

import com.example.movie.dto.CommentDTO;
import com.example.movie.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository cr;

    public String deleteComment(Long id) {
        int result = cr.deleteComment(id);
        if (result == 1) {
            return "success";
        } else {
            return "failed";
        }
    }

    public List<CommentDTO> selectAllCommentByMovieId(long movieId) {
        return cr.selectAllCommentByMovieId(movieId);
    }

    public List<CommentDTO> selectCommentByUserId(long memberId) {
        return cr.selectCommentByMemberId(memberId);
    }
    public List<CommentDTO> selectCommentByCommentId(long id) {
        return cr.selectCommentByCommentId(id);
    }

    public ArrayList<CommentDTO> selectComment(Long member_id) {
        if (cr.selectComment(member_id) == null) {
            return null;
        } else {
            return cr.selectComment(member_id);
        }
    }

}
