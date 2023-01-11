package com.example.movie.admin.repository;

import com.example.movie.admin.dto.AdminDTO;
import com.example.movie.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {

    @Autowired
    AdminMapper am;

    public AdminDTO selectAdmin(AdminDTO adminDTO) {
        return am.selectAdmin(adminDTO);
    }
}
