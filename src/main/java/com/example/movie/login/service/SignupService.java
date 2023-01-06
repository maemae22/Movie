package com.example.movie.login.service;

import com.example.movie.login.dto.MemberDTO;
import com.example.movie.login.repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class SignupService {
    private final SignupRepository signupRepository;

    public SignupService(SignupRepository signupRepository,@Autowired HttpSession session) {
        this.signupRepository = signupRepository;
        this.session = session;
    }

    public String signup(MemberDTO memberDTO) {

        signupRepository.signupMember(memberDTO);

        return "success";
    }
}
