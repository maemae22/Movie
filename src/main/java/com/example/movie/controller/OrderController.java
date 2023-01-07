package com.example.movie.controller;

import com.example.movie.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

@Controller
public class OrderController {

    @Autowired
    OrderService os;

    @ResponseBody
    @PutMapping("/ticket")
    public String updateOrderStatus(Long id) {
        return os.updateOrderStatus(id);
    }
}
