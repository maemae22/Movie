package com.example.movie.map.controller;

import com.example.movie.dto.OrderDTO;
import com.example.movie.map.dto.MapDTO;
import com.example.movie.map.service.MapService;
import com.example.movie.service.MemberService;
import com.example.movie.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class MapController {
    @Autowired
    MapService mapService;

    @Autowired
    OrderService or;

    @Autowired
    MemberService memberService;

    @GetMapping("/theater/detail/{id}")
    public String theaterDetail(@PathVariable Long id, Model model) {
        MapDTO theater = mapService.selectTheaterData(id);
        model.addAttribute("theater", theater);
        return "mypage/map";
    }

    @ResponseBody
    @GetMapping("/send")
    public void send(OrderDTO orderDTO, String movieNm, String theaterName) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> request = new HashMap<>();
        request.put("username", "예매내역확인"); //slack bot name
        request.put("text",
                "예매 번호 : " + orderDTO.getId() + "\n"
                + "영화 제목 : " + movieNm + "\n"
                + "관람 극장 : " + theaterName + "\n"
                + "관람 일시 : " + orderDTO.getScreenDate() + "\n"
                + "관람 좌석 : " + orderDTO.getSeat() + "\n"
                + "티켓 수 : " + orderDTO.getTicketCount() + "\n"
                + "총 결제 금액 : " + orderDTO.getTotalPrice()); //전송할 메세지

        request.put("icon_emoji", "https://img.cgv.co.kr/Movie/Thumbnail/Poster/000086/86072/86072_126.jpg"); //slack bot image

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request);

        String url = "https://hooks.slack.com/services/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"; //복사한 Webhook URL 입력

        restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
    }
}
