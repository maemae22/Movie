package com.example.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieDTO {

    private Long id;
    private String movieName;
    private Long movieCode;
    private String director;
    private String description;
    private int price;
    private String openDate;
    private String image;
    private int audienceCount;

}