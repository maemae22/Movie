package com.example.movie.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MemberDTO {

    private long id;
    private String userId;
    private String password;
    private String nickname;
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