package com.example.movie.service;

import com.example.movie.dto.CommentDTO;
import com.example.movie.dto.DailyMovieDTO;
import com.example.movie.dto.MovieDTO;
import com.example.movie.dto.OrderDTO;
import com.example.movie.repository.CommentRepository;
import com.example.movie.repository.MovieRepository;
import com.example.movie.repository.OrderRepository;
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
    public Integer selectDateInsertChk(){
        return mr.selectDateInsertChk();
    }

    public DailyMovieDTO selectMovieName(Long member_id) {
        Long id = or.selectMovieIdOne(member_id);
        return mr.selectMovieName(id);
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
