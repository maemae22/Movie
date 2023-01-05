package com.example.movie.mapper;

import com.example.movie.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface CommentMapper {
    ArrayList<CommentDTO> selectComment(Long member_id);
    ArrayList<CommentDTO> selectMovieId(Long member_id);

    int deleteComment(Long id);
}
