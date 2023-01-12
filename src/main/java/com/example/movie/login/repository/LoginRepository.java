package com.example.movie.login.repository;

import com.example.movie.dto.MemberDTO;
import com.example.movie.mapper.MemberMapper;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository {

    private final MemberMapper memberMapper;

    public LoginRepository(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public MemberDTO loginUserIdPassword(MemberDTO memberDTO) {
        return memberMapper.loginUserIdPassword(memberDTO);
    }

    public Long selectMemberIdByNickname(String email) { return memberMapper.selectMemberIdByNickname(email); }
}
