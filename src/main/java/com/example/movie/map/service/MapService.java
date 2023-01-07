package com.example.movie.map.service;

import com.example.movie.map.dto.MapDTO;
import com.example.movie.map.repository.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapService {

    @Autowired
    MapRepository repository;

    public MapDTO selectTheaterData(Long theater_id) {
        return repository.selectTheaterData(theater_id);
    }
}
