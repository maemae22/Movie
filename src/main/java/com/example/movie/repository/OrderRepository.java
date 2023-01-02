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

    public ArrayList<OrderDTO> selectCancelOrder(Long member_id) {
        return om.selectCancelOrder(member_id);
    }
    public OrderDTO selectOrderById(Long member_id) {
        return om.selectOrderById(member_id);
    }
}
