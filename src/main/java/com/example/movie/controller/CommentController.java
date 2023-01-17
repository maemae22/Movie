package com.example.movie.controller;

import com.example.movie.dto.CommentDTO;
import com.example.movie.dto.MemberDTO;
import com.example.movie.dto.MovieDTO;
import com.example.movie.service.CommentService;
import com.example.movie.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Api(tags = {"Comment Controller"}, description = "Comment(한줄평) 관련 CRUD RestController")
@RestController
public class CommentController {

    @Autowired
    CommentService cs;

    @ApiOperation(value = "영화 상세정보페이지에서 한줄평(comment) 추가", notes = "사용자가 입력한 한줄평을 ajax로 받아와 Comment 테이블에 insert하는 메서드")
    @PostMapping("/api/comment/add")
    public int insertComment(@RequestBody CommentDTO commentDTO) {
        return cs.insertComment(commentDTO);
    }

    @ApiOperation(value = "마이 페이지에서 평점 삭제", notes = "마이 페이지 내에서 내 평점을 삭제한다.")
    @DeleteMapping("/member/user-comment/{id}")
    public String deleteComment(@PathVariable Long id) {
        return cs.deleteCommentR(id);
    }

    @ApiOperation(value = "해당 영화 코드에 달린 모든 한줄평 반환", notes = "해당 영화 코드에 달려있는 모든 사용자의 한줄평을 반환한다. 영화 상세페이지에서 사용됨.")
    @GetMapping("/api/comments/{movieCd}")
    public List<CommentDTO> selectAllCommentByMovieId(@PathVariable int movieCd) {
        return cs.selectAllCommentByMovieId(movieCd);
    }

    @ApiOperation(value = "해당 Comment의 Good 개수를 1개 높여줌", notes = "commentId에 맞는 한줄평의 Good 컬럼의 숫자를 1개 높여줌. 영화 상세페이지에서 사용됨.")
    @PutMapping("/api/comment/GoodUp/{commentId}")
    public int updateGoodNumOneUpByCommentId(@PathVariable int commentId) {
        return cs.updateGoodNumOneUpByCommentId(commentId);
    }

    @ApiOperation(value = "해당 Comment의 Bad 개수를 1개 높여줌", notes = "commentId에 맞는 한줄평의 Bad 컬럼의 숫자를 1개 높여줌. 영화 상세페이지에서 사용됨.")
    @PutMapping("/api/comment/BadUp/{commentId}")
    public int updateBadNumOneUpByCommentId(@PathVariable int commentId) {
        return cs.updateBadNumOneUpByCommentId(commentId);
    }

    @ApiOperation(value = "한줄평(comment) 삭제", notes = "commentId에 맞는 한줄평을 삭제함. 영화 상세페이지에서 사용됨.")
    @DeleteMapping("/api/comment/delete/{commentId}")
    public int deleteComment(@PathVariable long commentId) {
        return cs.deleteComment(commentId);
    }

    @ApiOperation(value = "commentID로 해당 Comment의 상세정보 반환", notes = "commentId에 맞는 한줄평(상세정보)을 반환함. 영화 상세페이지에서 사용됨.")
    @PostMapping("/api/comment/{commentId}")
    public CommentDTO getComment(@PathVariable int commentId) {
        return cs.selectCommentByCommentId(commentId);
    }

    @ApiOperation(value = "commentID로 해당 Comment를 update", notes = "commentId에 맞는 한줄평(Comment)을 수정함(Update). 영화 상세페이지에서 사용됨.")
    @PutMapping("/api/comment/update/{commentId}")
    public int updateComment(@PathVariable int commentId, @RequestBody CommentDTO commentDTO) {
        return cs.updateComment(commentDTO);
    }
}
