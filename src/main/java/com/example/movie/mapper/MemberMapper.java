package com.example.movie.mapper;

import com.example.movie.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    int signupMember(MemberDTO memberDTO);
    MemberDTO loginUserIdPassword(MemberDTO memberDTO);
    Long selectMemberIdByNickname(String email);

    MemberDTO selectMemberDetail(String nickname);
    int updateMemberPassword(MemberDTO memberDTO);
    int updateMemberName(MemberDTO memberDTO);
    int updateIsMemberStatus(MemberDTO memberDTO);
    List<MemberDTO> selectAllCustomers();
    int memberStatus(MemberDTO memberDTO);
}
