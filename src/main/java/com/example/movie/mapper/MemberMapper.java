package com.example.movie.mapper;

import com.example.movie.login.dto.MemberDTO;
import com.example.movie.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int signupMember(MemberDTO memberDTO);

    MemberDTO loginUserIdPassword(MemberDTO memberDTO);
    MemberDTO selectMemberDetail(MemberDTO memberDTO);
    int updateMemberPassword(MemberDTO memberDTO);
    int updateMemberName(MemberDTO memberDTO);

}
