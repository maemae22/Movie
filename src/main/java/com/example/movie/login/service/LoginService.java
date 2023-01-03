package com.example.movie.login.service;

import com.example.movie.login.repository.LoginRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginService {

    private final LoginRepository loginRepository;
    private final HttpSession session;

    public LoginService(LoginRepository loginRepository, HttpSession session) {
        this.loginRepository = loginRepository;
        this.session = session;
    }
}
