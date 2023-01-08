package com.example.movie.service;

import com.example.movie.dto.DailyMovieDTO;
import com.example.movie.repository.CommentRepository;
import com.example.movie.repository.MovieRepository;
import com.example.movie.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
public class MovieService {

    private MovieRepository mr;
    private OrderRepository or;
    private CommentRepository cr;

    @Autowired
    public MovieService(MovieRepository mr, OrderRepository or, CommentRepository cr) {
        this.mr = mr;
        this.or = or;
        this.cr = cr;
    }

    public Integer selectDateInsertChk(){
        return mr.selectDateInsertChk();
    }

    public DailyMovieDTO selectMovieName(Long member_id) {
        if (or.selectMovieIdOne(member_id) == null) {
            return null;
        } else {
            Long id = or.selectMovieIdOne(member_id);
            return mr.selectMovieName(id);
        }
    }

    public ArrayList<DailyMovieDTO> selectMovieNames(Long member_id) {
        ArrayList<Long> ids = or.selectMovieIds(member_id);
        ArrayList<DailyMovieDTO> movieList = new ArrayList<>();

        for (int i = 0; i < ids.size(); i++) {
            movieList.add(mr.selectMovieName(ids.get(i)));
        }
        return movieList;
    }

    public ArrayList<DailyMovieDTO> selectCancelMovieNames(Long member_id) {
        ArrayList<Long> ids = or.selectCancelMovieIds(member_id);
        ArrayList<DailyMovieDTO> movieList = new ArrayList<>();

        for (int i = 0; i < ids.size(); i++) {
            movieList.add(mr.selectMovieName(ids.get(i)));
        }

        return movieList;
    }

    public ArrayList<DailyMovieDTO> selectMovieIdByComment(Long member_id) {
        ArrayList<Long> ids = cr.selectMovieId(member_id);
        ArrayList<DailyMovieDTO> movieList = new ArrayList<>();

        for (int i = 0; i < ids.size(); i++) {
            movieList.add(mr.selectMovieNameComment(ids.get(i)));
        }
        return movieList;
    }
}
