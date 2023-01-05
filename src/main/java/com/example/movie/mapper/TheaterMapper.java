package com.example.movie.mapper;

import com.example.movie.dto.OrderDTO;
import com.example.movie.dto.TheaterDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TheaterMapper {
    TheaterDTO selectTheaterName(OrderDTO orderDTO);
}
