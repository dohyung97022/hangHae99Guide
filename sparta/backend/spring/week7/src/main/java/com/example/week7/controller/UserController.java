package com.example.week7.controller;

import com.example.week7.dto.SignupRequestDto;
import com.example.week7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    @GetMapping("/user/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping("/user/kakao/callback")
    public String kakaoLogin(String code) {
        // authorizedCode: 카카오 서버로부터 받은 인가 코드
        userService.kakaoLogin(code);
        return "redirect:/";
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup(Model model) {
        return "signup";
    }

    // 회원 가입 요청 처리
    @PostMapping(value = "/user/signup")
    public String registerUser(RedirectAttributes redirectAttributes, SignupRequestDto requestDto) {
       try{
            userService.registerUser(requestDto);
        }catch (Exception e){
           redirectAttributes.addFlashAttribute("msg", e.getMessage());
            return "redirect:/user/signup";
        }
        return "redirect:/user/login";
    }

    @GetMapping("/user/forbidden")
    public String forbidden() {
        return "forbidden";
    }
}