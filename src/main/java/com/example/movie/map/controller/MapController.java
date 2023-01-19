package com.example.movie.map.controller;

import com.example.movie.dto.TicketDTO;
import com.example.movie.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Api(tags = {"알람 서비스"}, description = "예매 정보를 slack으로 전달합니다.")
@Controller
@Slf4j
public class MapController {

    @Autowired
    MemberService memberService;

    @ApiOperation(value = "예매 내역 전달", notes = "slack으로 내 예매 내역을 전달합니다.")
    @ResponseBody
    @GetMapping("/send")
    public void send(TicketDTO ticketDTO) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> request = new HashMap<>();
        request.put("username", "예매내역확인"); //slack bot name
        request.put("text",
                "예매 번호 : " + ticketDTO.getId() + "\n"
                + "영화 제목 : " + ticketDTO.getMovieTitle() + "\n"
                + "관람 극장 : " + ticketDTO.getSelectedTheater() + "\n"
                + "관람 일시 : " + ticketDTO.getMovieDate() + "\n"
                + "관람 좌석 : " + ticketDTO.getSelectedSeat() + "\n"
                + "티켓 수 : " + ticketDTO.getTicketNumber() + "\n"
                + "총 결제 금액 : " + ticketDTO.getPayMoney()); //전송할 메세지

        request.put("icon_emoji", "https://img.cgv.co.kr/Movie/Thumbnail/Poster/000086/86072/86072_126.jpg"); //slack bot image

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request);

        String url = "https://hooks.slack.com/services/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"; //복사한 Webhook URL 입력

        restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
    }
}
