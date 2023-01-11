package com.example.movie.login.service;

import com.example.movie.login.dto.MemberDTO;
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
    private HttpSession session;

    public LoginService(LoginRepository loginRepository, @Autowired HttpSession session) {
        this.loginRepository = loginRepository;
        this.session = session;
    }

    public String loginUserIdPassword(MemberDTO memberDTO) {
       MemberDTO member = loginRepository.loginUserIdPassword(memberDTO);
        if (member != null) {
            log.info("memberInfo = {}",member.toString());
            session.setAttribute("nickname",member.getNickname());
            return memberDTO.getNickname();
        }
        return "error";
    }

    public Long selectMemberIdByEmail(String email) { return loginRepository.selectMemberIdByNickname(email); }
}
