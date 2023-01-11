package com.example.movie.repository;

import com.example.movie.dto.CommentDTO;
import com.example.movie.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepository {

    @Autowired
    CommentMapper cm;

    public int insertComment(CommentDTO commentDTO) {
        return cm.insertComment(commentDTO);
    }

    public int updateComment(CommentDTO commentDTO) {
        return cm.updateComment(commentDTO);
    }

    public int deleteComment(long id) {
        return cm.deleteComment(id);
    }

    public List<CommentDTO> selectAllCommentByMovieId(long movieId) {
        return cm.selectAllCommentByMovieId(movieId);
    }

    public List<CommentDTO> selectCommentByMemberId(long memberId) {
        return cm.selectCommentByMemberId(memberId);
    }
    public CommentDTO selectCommentByCommentId(long id) {
        return cm.selectCommentByCommentId(id);
    }

    public int updateGoodNumOneUpByCommentId(long id) {
        return cm.updateGoodNumOneUpByCommentId(id);
    }
    public int updateBadNumOneUpByCommentId(long id) {
        return cm.updateBadNumOneUpByCommentId(id);
    }


}
