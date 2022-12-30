package com.example.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MemberDTO {

    private Long id;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String indate;
    private int isMember;

}