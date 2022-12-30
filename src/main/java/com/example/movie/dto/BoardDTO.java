package com.example.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoardDTO {

    private Long id;
    private String userId;
    private String title;
    private String content;
    private String indate;

}
