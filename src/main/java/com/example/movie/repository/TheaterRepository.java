package com.example.movie.repository;

import com.example.movie.dto.OrderDTO;
import com.example.movie.dto.TheaterDTO;
import com.example.movie.mapper.TheaterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TheaterRepository {

    @Autowired
    TheaterMapper tm;

    public TheaterDTO selectTheaterName(OrderDTO orderDTO) {
        return tm.selectTheaterName(orderDTO);
    }

}
