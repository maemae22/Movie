package com.example.movie.login.dto;

import com.example.movie.login.entity.Member;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDTO {
    private long id;
    private String userId;
    private String password;
<<<<<<< HEAD
<<<<<<< HEAD
    private String nickname;
=======
>>>>>>> #16-signup
=======
    private String nickname;
>>>>>>> origin/feature/#19-login
    private String name;
    private String email;
    private String phone;
    private String indate;
    private String isMember;
    private String role;

    public Member toEntity() {
        return Member.builder()
                .id(id)
                .userId(userId)
                .password(password)
<<<<<<< HEAD
<<<<<<< HEAD
                .nickname(nickname)
=======
>>>>>>> #16-signup
=======
                .nickname(nickname)
>>>>>>> origin/feature/#19-login
                .name(name)
                .email(email)
                .phone(phone)
                .indate(indate)
                .isMember(isMember)
                .role(role)
                .build();

    }

}
