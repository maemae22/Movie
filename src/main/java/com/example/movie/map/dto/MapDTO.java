package com.example.movie.map.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MapDTO {
    private Long id;
    private Long theater_id;
    private Float latitude;
    private Float longitude;
    private String theaterDetail;
}
