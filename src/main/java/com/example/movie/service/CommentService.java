package com.example.movie.service;

import com.example.movie.dto.CommentDTO;
import com.example.movie.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository cr;
    @Autowired
    HttpSession session;

    public int insertComment(CommentDTO commentDTO) {
        return cr.insertComment(commentDTO);
    }

    public int updateComment(CommentDTO commentDTO) {
        return cr.updateComment(commentDTO);
    }

    public int deleteComment(long id) {
        return cr.deleteComment(id);
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

    public int updateGoodNumOneUpByCommentId(long id) {
        return cr.updateGoodNumOneUpByCommentId(id);
    }
    public int updateBadNumOneUpByCommentId(long id) {
        return cr.updateBadNumOneUpByCommentId(id);
    }
}
