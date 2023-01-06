package com.example.movie.login.service;

import com.example.movie.login.dto.MemberDTO;
import com.example.movie.login.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;

    public String loginUserIdPassword(MemberDTO memberDTO, HttpSession session) {
        MemberDTO member = loginRepository.loginUserIdPassword(memberDTO);
        if (member != null) {
            log.info("memberInfo = {}", member.toString());
            session.setAttribute("nickname", member.getNickname());
            return "redirect:/";
        }
        return "error";
    }
}
