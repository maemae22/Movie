package com.example.movie.service;

import com.example.movie.dto.OrderDTO;
import com.example.movie.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService {

    @Autowired
    OrderRepository or;

    public ArrayList<OrderDTO> selectOrderByMember(Long member_id) {
        return or.selectOrderByMember(member_id);
    }

    public ArrayList<OrderDTO> selectMovieIds(Long member_id) {
        return or.selectMovieIds(member_id);
    }

    public ArrayList<OrderDTO> selectTheaterIds(Long member_id) {
        return or.selectTheaterIds(member_id);
    }

    public ArrayList<OrderDTO> selectCancelOrder(Long member_id) {
        return or.selectCancelOrder(member_id);
    }

    public ArrayList<OrderDTO> selectCancelMovieIds(Long member_id) {
        return or.selectCancelMovieIds(member_id);
    }

    public ArrayList<OrderDTO> selectCancelTheaterIds(Long member_id) {
        return or.selectCancelTheaterIds(member_id);
    }

    public OrderDTO selectOrderById(Long member_id) {
        return or.selectOrderById(member_id);
    }

    public OrderDTO selectIdOne(Long member_id) {
        return or.selectIdOne(member_id);
    }
}
