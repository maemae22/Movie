package com.example.movie.repository;

import com.example.movie.dto.MemberDTO;
import com.example.movie.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @Autowired
    MemberMapper mm;

//    public MemberDTO loginUserIdPassword(MemberDTO memberDTO) {
//        return mm.loginUserIdPassword(memberDTO);
//    }

    public MemberDTO selectMemberDetail(String nickname) {
        return mm.selectMemberDetail(nickname);
    }
    public int updateMemberName(MemberDTO memberDTO) {
        return mm.updateMemberName(memberDTO);
    }
    public int updateMemberPassword(MemberDTO memberDTO) {
        return mm.updateMemberPassword(memberDTO);
    }

    public int updateIsMemberStatus(MemberDTO memberDTO) {
        return mm.updateIsMemberStatus(memberDTO);
    }
}
