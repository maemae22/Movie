package com.example.movie.admin.controller;

import com.example.movie.admin.dto.AdminDTO;
import com.example.movie.admin.service.AdminService;
import com.example.movie.dto.MemberDTO;
import com.example.movie.dto.TheaterDTO;
import com.example.movie.service.MemberService;
import com.example.movie.service.TheaterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class AdminController {

    @Autowired
    AdminService as;

    @Autowired
    MemberService ms;

    @Autowired
    TheaterService ts;

    @PostMapping("/admin/login")
    public String login(AdminDTO adminDTO) {
        return as.selectAdmin(adminDTO);
    }

    @GetMapping("/admin/customers")
    public List<MemberDTO> selectCustomers() {
        return ms.selectAllCustomers();
    }

    @PutMapping("/admin/customers")
    public String updateCustomers(MemberDTO memberDTO) {
        ms.memberStatus(memberDTO);
        return "test";
    }

    @GetMapping("/admin/theaters")
    public List<TheaterDTO> selectTheaters() {
        return ts.selectTheaters();
    }

    @PostMapping("/admin/theaters")
    public String insertTheater(TheaterDTO theaterDTO) {
        return ts.insertTheater(theaterDTO);
    }

    @DeleteMapping("/admin/theaters")
    public String deleteTheater(TheaterDTO theaterDTO) {
        return ts.deleteTheater(theaterDTO);
    }
}
