package com.example.movie.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TheaterDTO {
    private Long id;
    private String theaterName;
    private String movieList;
    private String movieTimeList;
    private String theaterDetail;
}
