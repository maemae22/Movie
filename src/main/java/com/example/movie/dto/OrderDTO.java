package com.example.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDTO {

    private Long id;
    private Long member_id;
    private Long theater_id;
    private Long movie_id;
    private String movieName;
    private Long movieCode;
    private String theaterName;
    private String seat;
    private boolean orderStatus;
    private int ticketCount;
    private int totalPrice;
    private String indate;

}