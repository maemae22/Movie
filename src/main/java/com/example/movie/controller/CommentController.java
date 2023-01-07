package com.example.movie.controller;

import com.example.movie.dto.CommentDTO;
import com.example.movie.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CommentController {

    @Autowired
    CommentService cs;

    @DeleteMapping("/member/user-comment/{id}")
    public String deleteComment(@PathVariable Long id) {
        log.info("delete id = {}", id);
        return cs.deleteComment(id);
    }

}
