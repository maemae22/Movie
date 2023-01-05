//package com.example.movie.login.service;
//
//import com.example.movie.dto.MemberDTO;
//import com.example.movie.login.repository.SignupRepository;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpSession;
//
//@Service
//public class SignupService {
//    private final SignupRepository signupRepository;
//    private final HttpSession session;
//
//    public SignupService(SignupRepository signupRepository,HttpSession session) {
//        this.signupRepository = signupRepository;
//        this.session = session;
//    }
//
//    public String signup(MemberDTO memberDTO) {
//        Member member = memberDTO.toEntity();
//
//        signupRepository.signupMember(member);
//
//        return "success";
//    }
//}
