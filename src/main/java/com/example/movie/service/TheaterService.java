package com.example.movie.service;

import com.example.movie.dto.OrderDTO;
import com.example.movie.dto.TheaterDTO;
import com.example.movie.repository.OrderRepository;
import com.example.movie.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TheaterService {

    @Autowired
    TheaterRepository tr;

    @Autowired
    OrderRepository or;

    public TheaterDTO selectTheaterName(Long member_id) {
        OrderDTO order = or.selectIdOne(member_id);
        return tr.selectTheaterName(order);
    }

    public ArrayList<TheaterDTO> selectTheaterNames(Long member_id) {
        ArrayList<OrderDTO> order = or.selectTheaterIds(member_id);
        ArrayList<TheaterDTO> theaterList = new ArrayList<>();

        for (int i = 0; i < order.size(); i++) {
            theaterList.add(tr.selectTheaterName(order.get(i)));
        }

        return theaterList;
    }

    public ArrayList<TheaterDTO> selectCancelTheaterName(Long member_id) {
        ArrayList<OrderDTO> order = or.selectCancelTheaterIds(member_id);
        ArrayList<TheaterDTO> theaterList = new ArrayList<>();

        for (int i = 0; i < order.size(); i++) {
            theaterList.add(tr.selectTheaterName(order.get(i)));
        }

        return theaterList;
    }
}
