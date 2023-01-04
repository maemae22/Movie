package com.example.movie.login.dto;

import lombok.*;

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


}
