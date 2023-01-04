package com.example.movie.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DailyMovieDTO {

    private String movieCd;         //영화코드
    private String movieNm;         // 영화제목(국문)
    private LocalDate openDt;           // 개봉일
    private int movieRank;          // 일별 영화순위
    private Long audiAcc;           //누적 관객수

}
