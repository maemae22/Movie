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
    private String name;
    private String nickname;
    private String phone;
    private String address;
    private String addressDetail;
    private String email;
    private String gender;
    private String sns;
    private String birth;
    private String indate;
    private String isMember;
    private String role;


}
