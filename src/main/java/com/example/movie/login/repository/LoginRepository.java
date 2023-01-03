package com.example.movie.login.repository;

import com.example.movie.mapper.MemberMapper;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository {

    private final MemberMapper memberMapper;

    public LoginRepository(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public loginUserIdPassword
}
