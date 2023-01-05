package com.example.movie.service;

import com.example.movie.dto.CommentDTO;
import com.example.movie.dto.MovieDTO;
import com.example.movie.dto.OrderDTO;
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

    @Autowired
    MovieRepository mr;

    @Autowired
    OrderRepository or;

    @Autowired
    CommentRepository cr;

    public MovieDTO selectMovieName(Long member_id) {
        OrderDTO order = or.selectIdOne(member_id);
        log.info("order(name) = {}", order);
        return mr.selectMovieName(order);
    }

    public ArrayList<MovieDTO> selectMovieNames(Long member_id) {
        ArrayList<OrderDTO> order = or.selectMovieIds(member_id);
        ArrayList<MovieDTO> movieList = new ArrayList<>();

        log.info("order = {}", order);

        for (int i = 0; i < order.size(); i++) {
            movieList.add(mr.selectMovieName(order.get(i)));
        }
        log.info("movieList {}", movieList);

        return movieList;
    }

    public ArrayList<MovieDTO> selectCancelMovieNames(Long member_id) {
        ArrayList<OrderDTO> order = or.selectCancelMovieIds(member_id);
        ArrayList<MovieDTO> movieList = new ArrayList<>();

        log.info("order = {}", order);

        for (int i = 0; i < order.size(); i++) {
            movieList.add(mr.selectMovieName(order.get(i)));
        }
        log.info("movieList {}", movieList);

        return movieList;
    }

    public ArrayList<MovieDTO> selectMovieIdByComment(Long member_id) {
        ArrayList<CommentDTO> comment = cr.selectMovieId(member_id);
        ArrayList<MovieDTO> movieList = new ArrayList<>();

        for (int i = 0; i < comment.size(); i++) {
            movieList.add(mr.selectMovieNameComment(comment.get(i)));
        }

        return movieList;
    }
}
