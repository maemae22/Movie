package com.example.movie.login.dto;

import com.example.movie.login.entity.Member;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MemberDTO {
    private long id;
    private String userId;
    private String password;
    private String nickname;
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
                .nickname(nickname)
                .name(name)
                .email(email)
                .phone(phone)
                .indate(indate)
                .isMember(isMember)
                .role(role)
                .build();

    }

}
