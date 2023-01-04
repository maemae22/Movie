package com.example.movie.mapper;

import com.example.movie.login.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int signupMember(MemberDTO memberDTO);

    MemberDTO loginUserIdPassword(MemberDTO memberDTO);

}
