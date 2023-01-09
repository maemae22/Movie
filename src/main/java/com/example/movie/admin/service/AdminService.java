package com.example.movie.admin.service;

import com.example.movie.admin.dto.AdminDTO;
import com.example.movie.admin.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AdminService {

    @Autowired
    AdminRepository ar;
    @Autowired
    HttpSession session;

    public String selectAdmin(AdminDTO adminDTO) {
        AdminDTO fetched = ar.selectAdmin(adminDTO);

        if (fetched == null) {
            return "failed";
        } else {
            session.setAttribute("admin", fetched);
            return "success";
        }
    }
}
