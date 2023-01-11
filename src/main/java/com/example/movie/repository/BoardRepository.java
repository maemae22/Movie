package com.example.movie.repository;

import com.example.movie.dto.BoardDTO;
import com.example.movie.dto.ReplyDTO;
import com.example.movie.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final BoardMapper bm;

    public List<BoardDTO> selectBoard() {
        return bm.selectBoard();
    }

    public BoardDTO selectBoardDetail(String id) {
        return bm.selectBoardDetail(id);
    }

    public int insertBoard(BoardDTO boardDTO) {
        return bm.insertBoard(boardDTO);
    }

    public int updateBoard(BoardDTO boardDTO) {
        return bm.updateBoard(boardDTO);
    }

    public int deleteBoard(BoardDTO boardDTO) {
        return bm.deleteBoard(boardDTO);
    }

    public List<ReplyDTO> selectReply() {
        return bm.selectReply();
    }

    public int insertReply(ReplyDTO replyDTO) {
        return bm.insertReply(replyDTO);
    }

    public int updateReply(ReplyDTO replyDTO) {
        return bm.updateReply(replyDTO);
    }

    public int deleteReply(ReplyDTO replyDTO) {
        return bm.deleteReply(replyDTO);
    }

}
