package com.example.movie.page.controller;

import com.example.movie.dto.MemberDTO;
import com.example.movie.service.MemberService;
import com.example.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@Slf4j
@RequiredArgsConstructor
public class PageController {
    private final MovieService ms;

    @Autowired
    MemberService memberService;

    @GetMapping("/")
    public String index(Model model) {
        ArrayList<HashMap<String, String>> rankLists = ms.selectDailyRank();
        for (HashMap<String, String> rankList : rankLists) {
            String str = rankList.get("movie_img");
            String[] splitArray = str.split("\\|");
            rankList.put("movie_img", splitArray[0]);
        }

        model.addAttribute("rankLists", rankLists);
        return "index";
    }

    @GetMapping("/movie")
    public String movieList() {
        return "movies";
    }

    @GetMapping("/movie/{movieCode}")
    public String movieDetail(@PathVariable int movieCode, Model model, Authentication authentication) {
        model.addAttribute("movieCode", movieCode);

        MemberDTO memberDTO = memberService.selectMemberDetail(authentication.getName());
        model.addAttribute("memberDTO", memberDTO);
        model.addAttribute("memberId", memberDTO.getId());
        model.addAttribute("nickname", memberDTO.getNickname());

        return "movie_detail";
    }

}
