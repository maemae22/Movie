package com.example.movie.login.repository;

import com.example.movie.dto.MemberDTO;
import com.example.movie.mapper.MemberMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SignupRepository {
    private final MemberMapper memberMapper;

    public SignupRepository(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public int signupMember(MemberDTO memberDTO) {
        return memberMapper.signupMember(memberDTO);
    }

}
