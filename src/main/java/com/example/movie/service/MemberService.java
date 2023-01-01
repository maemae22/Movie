package com.example.movie.service;

import com.example.movie.dto.MemberDTO;
import com.example.movie.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberRepository mr;

    public MemberDTO selectLogin(MemberDTO memberDTO) {
        return mr.selectLogin(memberDTO);
    }

    public MemberDTO selectMemberDetail(String email) {
        return mr.selectMemberDetail(email);
    }

    public String updateMemberName(MemberDTO memberDTO) {
        return String.valueOf(mr.updateMemberName(memberDTO));
    }

    public String updateMemberPassword(MemberDTO memberDTO) {
        return String.valueOf(mr.updateMemberPassword(memberDTO));
    }
}
