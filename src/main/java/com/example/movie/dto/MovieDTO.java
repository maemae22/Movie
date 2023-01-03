package com.example.movie.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MovieDTO {

    private Long id;
    private String movieName;
    private Long movieCode;
    private String director;
    private String description;
    private String openDate;
    private String image;

}