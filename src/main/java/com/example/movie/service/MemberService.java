package com.example.movie.service;

import com.example.movie.dto.MemberDTO;
import com.example.movie.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberRepository mr;

//    public MemberDTO loginUserIdPassword(MemberDTO memberDTO) {
//        return mr.loginUserIdPassword(memberDTO);
//    }

    public MemberDTO selectMemberDetail(String nickname) {
        return mr.selectMemberDetail(nickname);
    }

    public String updateMemberName(MemberDTO memberDTO) {
        return String.valueOf(mr.updateMemberName(memberDTO));
    }

    public String updateMemberPassword(MemberDTO memberDTO) {
        return String.valueOf(mr.updateMemberPassword(memberDTO));
    }

    public String updateIsMemberStatus(MemberDTO memberDTO) {
        int result = mr.updateIsMemberStatus(memberDTO);

        if (result == 1) {
            return "success";
        } else {
            return "failed";
        }
    }
}
