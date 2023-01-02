package com.example.movie.mapper;

import com.example.movie.login.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int signupMember(Member member);

}
