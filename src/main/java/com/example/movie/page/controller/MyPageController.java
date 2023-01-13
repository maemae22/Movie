package com.example.movie.page.controller;

import com.example.movie.dto.*;
import com.example.movie.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/member")
@Controller
public class MyPageController {
    private final MemberService ms;
    private final OrderService os;
    private final MovieService movieService;
    private final TheaterService ts;
    private final CommentService cs;

    @GetMapping
    public String myPage(Model model, Authentication authentication) {
        MemberDTO memberDTO = ms.selectMemberDetail(authentication.getName());

        ArrayList<OrderDTO> orderList = os.selectOrderByMember(memberDTO.getId());

        OrderDTO order = os.selectOrderById(memberDTO.getId());
        MovieDTO movie = movieService.selectMovieImg(memberDTO.getId());
        DailyMovieDTO movieDTO = movieService.selectMovieName(memberDTO.getId());
        TheaterDTO theaterDTO = ts.selectTheaterName(memberDTO.getId());

        ArrayList<CommentDTO> commentList = cs.selectComment(memberDTO.getId());

        model.addAttribute("memberDTO", memberDTO);
        model.addAttribute("orderList", orderList);
        model.addAttribute("recentOrder", order);
        model.addAttribute("recentMovieImg", movie);
        model.addAttribute("recentMovie", movieDTO);
        model.addAttribute("recentTheater", theaterDTO);
        model.addAttribute("commentList", commentList);

        return "/mypage/mypage";
    }

    @GetMapping("/user-detail")
    public String userDetail(Authentication authentication, Model model) {
        MemberDTO memberDTO = ms.selectMemberDetail(authentication.getName());
        model.addAttribute("memberDTO", memberDTO);
        return "/mypage/user-detail";
    }

    @GetMapping("/user-edit/name")
    public String userEditName(Authentication authentication, Model model) {
        MemberDTO memberDTO = ms.selectMemberDetail(authentication.getName());
        model.addAttribute("memberDTO", memberDTO);
        return "/mypage/user-edit-name";
    }
    @ResponseBody
    @PostMapping("/user-edit/name")
    public String updateName(MemberDTO memberDTO, Authentication authentication) {
        MemberDTO member = ms.selectMemberDetail(authentication.getName());
        member.setName(memberDTO.getName());
        return ms.updateMemberName(member);
    }

    @GetMapping("/user-edit/password")
    public String userEditPassword(Authentication authentication, Model model) {
        MemberDTO memberDTO = ms.selectMemberDetail(authentication.getName());
        model.addAttribute("memberDTO", memberDTO);
        return "/mypage/user-edit-password";
    }

    @ResponseBody
    @PostMapping("/user-edit/password")
    public String updatePassword(MemberDTO memberDTO, Authentication authentication) {
        MemberDTO member = ms.selectMemberDetail(authentication.getName());
        member.setPassword(memberDTO.getPassword());
        return ms.updateMemberPassword(member);
    }

    @GetMapping("/user-comment")
    public String userComment(Authentication authentication, Model model) {
        MemberDTO memberDTO = ms.selectMemberDetail(authentication.getName());
        ArrayList<CommentDTO> commentList = cs.selectComment(memberDTO.getId());
        List<DailyMovieDTO> movieList = movieService.selectMovieNameByCode(memberDTO.getId());

        model.addAttribute("memberDTO", memberDTO);
        model.addAttribute("commentList", commentList);
        model.addAttribute("movieList", movieList);
        return "/mypage/user-comment";
    }

    @GetMapping("/user-order")
    public String userOrder(Authentication authentication, Model model) {
        MemberDTO memberDTO = ms.selectMemberDetail(authentication.getName());

        ArrayList<OrderDTO> orderList = os.selectOrderByMember(memberDTO.getId());
        ArrayList<OrderDTO> cancelList = os.selectCancelOrder(memberDTO.getId());

        ArrayList<DailyMovieDTO> movieList = movieService.selectMovieNames(memberDTO.getId());
        ArrayList<MovieDTO> movie = movieService.selectMovieImgs(memberDTO.getId());
        ArrayList<TheaterDTO> theaterList = ts.selectTheaterNames(memberDTO.getId());

        ArrayList<DailyMovieDTO> movieCancelList = movieService.selectCancelMovieNames(memberDTO.getId());
        ArrayList<TheaterDTO> theaterCancelList = ts.selectCancelTheaterName(memberDTO.getId());

        model.addAttribute("memberDTO", memberDTO);
        model.addAttribute("orderList", orderList);
        model.addAttribute("cancelList", cancelList);

        model.addAttribute("movieList", movieList);
        model.addAttribute("movie", movie);
        model.addAttribute("theaterList", theaterList);

        model.addAttribute("movieCancelList", movieCancelList);
        model.addAttribute("theaterCancelList", theaterCancelList);
        return "/mypage/user-order";
    }

    @GetMapping("/withdrawal")
    public String withdraw() {
        return "mypage/withdrawal";
    }

    @GetMapping("/theater/detail/{id}")
    public String theaterDetail(@PathVariable Long id, Model model) {
        TheaterDTO theater = ts.selectTheaterData(id);
        model.addAttribute("theater", theater);
        return "mypage/map";
    }

}
