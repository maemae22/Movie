package com.example.movie.controller;

import com.example.movie.dto.CommentDTO;
import com.example.movie.dto.MovieDTO;
import com.example.movie.login.service.LoginService;
import com.example.movie.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class CommentController {

    @Autowired
    CommentService cs;
    @Autowired
    LoginService ls;

    @PostMapping("/api/comment/add")
    public int insertComment(@RequestBody CommentDTO commentDTO) {
        return cs.insertComment(commentDTO);
    }

    @GetMapping("/api/comments/{movieCd}")
    public List<CommentDTO> selectAllCommentByMovieId(@PathVariable int movieCd) {
        return cs.selectAllCommentByMovieId(movieCd);
    }

    @PutMapping("/api/comment/GoodUp/{commentId}")
    public int updateGoodNumOneUpByCommentId(@PathVariable int commentId) {
//        System.out.println("updateGoodNumOneUpByCommentId");
        return cs.updateGoodNumOneUpByCommentId(commentId);
    }

    @PutMapping("/api/comment/BadUp/{commentId}")
    public int updateBadNumOneUpByCommentId(@PathVariable int commentId) {
//        System.out.println("updateBadNumOneUpByCommentId");
        return cs.updateBadNumOneUpByCommentId(commentId);
    }

    @DeleteMapping("/api/comment/delete/{commentId}")
    public int deleteComment(@PathVariable int commentId) {
        return cs.deleteComment(commentId);
    }

    @PostMapping("/api/comment/{commentId}")
    public CommentDTO getComment(@PathVariable int commentId) {
        return cs.selectCommentByCommentId(commentId);
    }

    @PutMapping("/api/comment/update/{commentId}")
    public int updateComment(@PathVariable int commentId, @RequestBody CommentDTO commentDTO) {
        return cs.updateComment(commentDTO);
    }
}
