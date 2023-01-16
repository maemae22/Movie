package com.example.movie.controller;

import com.example.movie.dto.TicketDTO;
import com.example.movie.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class TicketController {

    private final com.example.movie.service.TicketService TicketService;

    @Autowired
    public TicketController(TicketService TicketService) {
        this.TicketService = TicketService;
    }

    private static Logger logger = LoggerFactory.getLogger(InfoController.class);


    @RequestMapping(value = "moveSeat.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String moveSeat(Model model, TicketDTO dto) {

        logger.info("예매 페이지");
        System.out.println(dto.toString());

        model.addAttribute("ticket", dto);

        return "seat";
    }

    @RequestMapping(value = "moveKakao.do", method = {RequestMethod.GET, RequestMethod.POST})
    public void moveKakao(TicketDTO dto) {
        String[] list = dto.getSelectedTheater().split(" ");
        dto.setSelectedTheater(list[0]);
        dto.setTheaterDetail(list[1]);

        logger.info("좌석 페이지");
        System.out.println("{dto} = " + dto.toString());

        dto.setUserId("ryusun");
        int result = TicketService.insertTicket(dto);
        logger.info("result{} = " + result);

    }

    @RequestMapping(value = "payticket.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String payTicket(Model model){
        TicketDTO ticket = TicketService.getTicket();
        logger.info("결제창 getTicket{} = " + ticket.toString());
        model.addAttribute("ticket", ticket);
        return "payticket";
    }


    @RequestMapping(value = "complete.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String payComplete(Model model) {
        logger.info("결제완료");
        TicketDTO dto = TicketService.getTicket();
        model.addAttribute("ticket", dto);
        System.out.println("Ticket : " +dto.toString());

        return "payComplete";
    }

    @PostMapping("/payKakao")
    @ResponseBody
    public String payKakao(@RequestParam String amount, HttpSession session, Model model) {
        logger.info("amount {}", amount);


        if (amount != "0" || amount !=null){
            return "결제가 성공되었습니다.";
    } else {
            return "결제가 실패했습니다.";

        }
}

}







