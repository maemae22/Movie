package com.example.movie.mapper;

<<<<<<< Updated upstream
=======
import com.example.movie.login.dto.MemberDTO;
import com.example.movie.login.entity.Member;
>>>>>>> Stashed changes
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
<<<<<<< Updated upstream
=======
    int signupMember(Member member);

    MemberDTO loginUserIdPassword(MemberDTO memberDTO);

>>>>>>> Stashed changes
}
