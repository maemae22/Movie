package com.example.movie.controller;

import com.example.movie.dto.BoardDTO;
import com.example.movie.dto.ReplyDTO;
import com.example.movie.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"게시판 서비스"}, description = "게시판 CRUD 관련 서비스를 담당합니다.")
@RestController
public class BoardController {

    @Autowired
    BoardService bs;

    @GetMapping("/api/selectBoard")
    @ApiOperation(value = "전체 게시글 조회", notes = "전체 게시글을 조회한다.")
    public List<BoardDTO> selectBoard() {
        return bs.selectBoard();
    }

    @GetMapping("/api/selectBoard/{id}")
    @ApiOperation(value = "특정 게시글 조회", notes = "특정 게시글을 id 기준으로 조회한다.")
    public BoardDTO selectBoardDetail(@PathVariable String id, Model model) {
        model.addAttribute("board", bs.selectBoardDetail(id));
        return bs.selectBoardDetail(id);
    }

    @PostMapping("/api/insertBoard")
    @ApiOperation(value = "게시글 작성", notes = "게시글을 작성한다.")
    public int insertBoard(BoardDTO boardDTO) {
        return bs.insertBoard(boardDTO);
    }

    @PutMapping("/api/updateBoard")
    @ApiOperation(value = "특정 게시글 수정", notes = "특정 게시글을 수정한다.")
    public String updateBoard(BoardDTO boardDTO) {
        return bs.updateBoard(boardDTO);
    }

    @DeleteMapping("/api/deleteBoard")
    @ApiOperation(value = "게시글 삭제", notes = "특정 게시글을 삭제한다.")
    public String deleteBoard(BoardDTO boardDTO) {
        return bs.deleteBoard(boardDTO);
    }

    @GetMapping("/api/selectReply")
    @ApiOperation(value = "게시글의 리플 조회", notes = "특정 게시글의 리플을 조회한다.")
    public List<ReplyDTO> selectReply() {
        return bs.selectReply();
    }

    @PostMapping("/api/insertReply")
    @ApiOperation(value = "게시글의 리플 작성", notes = "특정 게시글의 리플을 작성한다.")
    public int insertReply(ReplyDTO replyDTO) {
        return bs.insertReply(replyDTO);
    }

    @PutMapping("/api/updateReply")
    @ApiOperation(value = "게시글의 리플 수정", notes = "특정 게시글의 리플을 수정한다.")
    public String updateReply(ReplyDTO replyDTO) {
        return bs.updateReply(replyDTO);
    }

    @DeleteMapping("/api/deleteReply")
    @ApiOperation(value = "게시글의 리플 삭제", notes = "특정 게시글의 리플을 삭제한다.")
    public String deleteReply(ReplyDTO replyDTO) {
        return bs.deleteReply(replyDTO);
    }

}
