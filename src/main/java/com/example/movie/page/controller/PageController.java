package com.example.movie.page.controller;

import com.example.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
        return "movie";
    }

    @GetMapping("/movie/{movieCode}")
    public String movieDetail(@PathVariable int movieCode, Model model) {
        model.addAttribute("movieCode", movieCode);
        return "movie_detail";
    }

    @GetMapping("/board")
    public String board() {
        return "board";
    }

    @GetMapping("/board/{id}")
    public String boardDetail(@PathVariable String id, Model model) {
        model.addAttribute("id", id);
        return "boardDetail";
    }

    @GetMapping("/board/insert")
    public String insertBoard() {
        return "boardInsert";
    }

    @GetMapping("/board/update/{id}")
    public String updateBoard(@PathVariable String id, Model model) {
        model.addAttribute("id", id);
        return "boardUpdate";
    }

}
