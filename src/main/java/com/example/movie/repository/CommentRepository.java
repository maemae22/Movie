package com.example.movie.repository;

import com.example.movie.dto.CommentDTO;
import com.example.movie.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CommentRepository {

    @Autowired
    CommentMapper cm;

    public List<CommentDTO> selectAllCommentByMovieId(long movieId) {
        return cm.selectAllCommentByMovieId(movieId);
    }

    public List<CommentDTO> selectCommentByMemberId(long memberId) {
        return cm.selectCommentByMemberId(memberId);
    }
    public List<CommentDTO> selectCommentByCommentId(long id) {
        return cm.selectCommentByCommentId(id);
    }

    public ArrayList<CommentDTO> selectComment(Long member_id) {
        return cm.selectComment(member_id);
    }

    public ArrayList<Long> selectMovieId(Long member_id) {
        return cm.selectMovieId(member_id);
    }

    public int deleteComment(Long id) {
        return cm.deleteComment(id);
    }
}
