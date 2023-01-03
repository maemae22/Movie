package com.example.movie.login.service;

import com.example.movie.login.dto.MemberDTO;
import com.example.movie.login.entity.Member;
import com.example.movie.login.repository.SignupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final SignupRepository signupRepository;
    private HttpSession session;


    public String signup(MemberDTO memberDTO) {
        Member member = memberDTO.toEntity();

        signupRepository.signupMember(member);

        return "success";
    }
}
