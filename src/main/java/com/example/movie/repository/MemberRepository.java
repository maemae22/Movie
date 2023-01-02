package com.example.movie.repository;

import com.example.movie.dto.MemberDTO;
import com.example.movie.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @Autowired
    MemberMapper mm;

    public MemberDTO selectLogin(MemberDTO memberDTO) {
        return mm.selectLogin(memberDTO);
    }

    public MemberDTO selectMemberDetail(MemberDTO memberDTO) {
        return mm.selectMemberDetail(memberDTO);
    }
    public int updateMemberName(MemberDTO memberDTO) {
        return mm.updateMemberName(memberDTO);
    }
    public int updateMemberPassword(MemberDTO memberDTO) {
        return mm.updateMemberPassword(memberDTO);
    }
}
