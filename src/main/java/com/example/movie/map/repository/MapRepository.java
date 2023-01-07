package com.example.movie.map.repository;

import com.example.movie.map.dto.MapDTO;
import com.example.movie.mapper.MapTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MapRepository {

    @Autowired
    MapTestMapper mapper;

    public MapDTO selectTheaterData(Long theater_id) {
        return mapper.selectTheaterData(theater_id);
    }
}
