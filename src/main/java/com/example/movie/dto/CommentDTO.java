package com.example.movie.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CommentDTO {

    private Long id;
    private Long member_id;
    private Long movie_id;
    private String content;
    private String indate;
    private int good;
    private int bad;

}