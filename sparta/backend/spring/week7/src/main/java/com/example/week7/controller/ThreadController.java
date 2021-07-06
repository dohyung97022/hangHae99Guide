package com.example.week7.controller;

import com.example.week7.dto.ThreadDto;
import com.example.week7.security.UserDetailsImpl;
import com.example.week7.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public String createThread(@AuthenticationPrincipal UserDetailsImpl userDetails, ThreadDto threadDto, RedirectAttributes redirectAttributes) {
        try {
            threadService.createThread(threadDto, userDetails);
            redirectAttributes.addFlashAttribute("msg", "글이 저장되었습니다.");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("msg", e.getMessage());
        }
        return "redirect:/";
    }


    // 쓰레드 수정
    @PatchMapping(value = "/thread/{threadId}")
    public String editThread(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long threadId, ThreadDto threadDto, RedirectAttributes redirectAttributes) {
        try {
            threadService.updateThread(threadDto, userDetails, threadId);
            redirectAttributes.addFlashAttribute("msg", "글이 수정되었습니다.");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("msg", e.getMessage());
        }
        return "redirect:/";
    }
}
