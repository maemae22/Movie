package com.example.movie.mapper;

import com.example.movie.dto.OrderDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface OrderMapper {
    ArrayList<OrderDTO> selectOrderByMember(Long member_id);
    ArrayList<OrderDTO> selectCancelOrder(Long member_id);
    OrderDTO selectOrderById(Long member_id);
}
