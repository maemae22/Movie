package com.example.movie.repository;

import com.example.movie.dto.OrderDTO;
import com.example.movie.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class OrderRepository {

    @Autowired
    OrderMapper om;

    public ArrayList<OrderDTO> selectOrderByMember(Long member_id) {
        return om.selectOrderByMember(member_id);
    }

    public ArrayList<OrderDTO> selectMovieIds(Long member_id) {
        return om.selectMovieIds(member_id);
    }

    public ArrayList<OrderDTO> selectTheaterIds(Long member_id) {
        return om.selectTheaterIds(member_id);
    }

    public ArrayList<OrderDTO> selectCancelOrder(Long member_id) {
        return om.selectCancelOrder(member_id);
    }

    public ArrayList<OrderDTO> selectCancelMovieIds(Long member_id) {
        return om.selectCancelMovieIds(member_id);
    }

    public ArrayList<OrderDTO> selectCancelTheaterIds(Long member_id) {
        return om.selectCancelTheaterIds(member_id);
    }
    public OrderDTO selectOrderById(Long member_id) {
        return om.selectOrderById(member_id);
    }

    public OrderDTO selectIdOne(Long member_id) {
        return om.selectIdOne(member_id);
    }
}
