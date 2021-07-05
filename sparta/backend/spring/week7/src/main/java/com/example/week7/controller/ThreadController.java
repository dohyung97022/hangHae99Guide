package com.example.week7.controller;

import com.example.week7.dto.CreateThreadDto;
import com.example.week7.security.UserDetailsImpl;
import com.example.week7.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ThreadController {
    private final ThreadService threadService;

    @Autowired
    public ThreadController(ThreadService threadService) {
        this.threadService = threadService;
    }

    // 쓰레드 작성
    @PostMapping(value = "/thread")
    public String createThread(@AuthenticationPrincipal UserDetailsImpl userDetails, CreateThreadDto createThreadDto, RedirectAttributes redirectAttributes) {
        try {
            threadService.createThread(createThreadDto, userDetails);
            redirectAttributes.addFlashAttribute("msg", "글이 저장되었습니다.");
        }catch (Exception e){
            System.out.println("e.getClass().getSimpleName() = " + e.getClass().getSimpleName());
            redirectAttributes.addFlashAttribute("msg", e.getMessage());
        }
        return "redirect:/";
    }
}
