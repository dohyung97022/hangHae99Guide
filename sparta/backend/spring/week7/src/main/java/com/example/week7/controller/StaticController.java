package com.example.week7.controller;

import com.example.week7.domain.Thread;
import com.example.week7.repository.ThreadRepository;
import com.example.week7.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StaticController {
    @Autowired
    private ThreadRepository threadRepository;

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        List<Thread> threads = threadRepository.findAllByOrderByCreatedAtDesc();
        model.addAttribute("threads", threads);

        if (userDetails!=null){
            model.addAttribute("username", userDetails.getUsername());
        }
        return "index";
    }
}
