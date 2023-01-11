package com.example.movie.login.service;

import com.example.movie.dto.MemberDTO;
import com.example.movie.login.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@Slf4j
public class LoginService {

    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public String loginUserIdPassword(MemberDTO memberDTO, HttpSession session) {
        MemberDTO member = loginRepository.loginUserIdPassword(memberDTO);

        if (member != null) {
            session.setAttribute("nickname", member.getNickname());
            return "redirect:/";
        }
        return "error";
    }

    public Long selectMemberIdByEmail(String email) { return loginRepository.selectMemberIdByNickname(email); }
}
