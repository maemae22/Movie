package com.example.movie.login.service;

import com.example.movie.login.dto.MemberDTO;
import com.example.movie.login.repository.SignupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final SignupRepository signupRepository;


    public String signup(MemberDTO memberDTO) {

        signupRepository.signupMember(memberDTO);

        return "success";
    }
}
