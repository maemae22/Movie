package com.example.movie.mapper;

import com.example.movie.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    MemberDTO selectLogin(MemberDTO memberDTO);
    MemberDTO selectMemberDetail(String email);
    int updateMemberName(MemberDTO memberDTO);
    int updateMemberPassword(MemberDTO memberDTO);
}
