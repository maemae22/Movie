package com.example.movie.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MemberDTO {

    private Long id;
    private String userId;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String indate;
    private int isMember;

}