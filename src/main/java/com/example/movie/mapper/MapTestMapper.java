package com.example.movie.mapper;

import com.example.movie.map.dto.MapDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MapTestMapper {
    MapDTO selectTheaterData(Long theater_id);
}
