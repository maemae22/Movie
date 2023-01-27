package com.example.movie.page.controller;

import com.example.movie.dto.MemberDTO;
import com.example.movie.service.MemberService;
import com.example.movie.dto.MovieDTO;
import com.example.movie.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.example.movie.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@Api(tags = {"Page Controller"}, description = "메인 페이지 | 영화 페이지 | 영화 상세 페이지")
public class PageController {
    private final MovieService ms;

    @Autowired
    MemberService memberService;

    @ApiOperation(value = "메인 페이지", notes = "영화 api 를 사용하여 가져온 일별 박스 오피스 순위를 보여줍니다.")
    @GetMapping("/")
    public String index(Model model, Authentication authentication) {
        ArrayList<HashMap<String, String>> rankLists = ms.selectDailyRank();
        for (HashMap<String, String> rankList : rankLists) {
            String str = rankList.get("movie_img");
            if(str.equals("")){
                rankList.put("movie_img", "/image/image_ready.jpeg");
            } else {
                String[] splitArray = str.split("\\|");
                rankList.put("movie_img", splitArray[0]);
            }
        }

        model.addAttribute("rankLists", rankLists);
        if(authentication != null) model.addAttribute("loginUser",authentication.getName());   // 로그인 유저 확인 하기 위해 추가됨.

        return "index";
    }

    @ApiOperation(value = "영화 메인(list) 페이지 (/movie)", notes = "/movie 접속 시 movies.html로 이동시켜주는 PageController 메서드입니다.")
    @GetMapping("/movie")
    public String movieList() {
        return "movies";
    }

    @ApiOperation(value = "영화 상세페이지 (/movie/{movieCode})",
                    notes = "영화 상세페이지로 이동시켜주는 PageController 메서드입니다. model에 movieCode 및 사용자 정보를 넣어주며, movie_detail.html을 반환합니다.(페이지 이동)")
    @GetMapping("/movie/{movieCode}")
    public String movieDetail(@PathVariable int movieCode, Model model, @ApiIgnore Authentication authentication) {
        model.addAttribute("movieCode", movieCode);

        MemberDTO memberDTO = memberService.selectMemberDetail(authentication.getName());
        model.addAttribute("memberDTO", memberDTO);
        model.addAttribute("memberId", memberDTO.getId());
        model.addAttribute("nickname", memberDTO.getNickname());

        return "movie_detail";
    }



}
