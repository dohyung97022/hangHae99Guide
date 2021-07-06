package com.example.week7.controller;

import com.example.week7.dto.DeleteResponseDto;
import com.example.week7.security.UserDetailsImpl;
import com.example.week7.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class ThreadRestController {
    private final ThreadService threadService;

    @Autowired
    public ThreadRestController(ThreadService threadService) {
        this.threadService = threadService;
    }

    @RequestMapping(value = "/thread/{threadId}", method = RequestMethod.DELETE)
    public DeleteResponseDto deleteThread(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long threadId){
        DeleteResponseDto deleteResponseDto = new DeleteResponseDto();
        if (userDetails != null){
         deleteResponseDto.setLoggedIn(true);
        }
        try {
            threadService.deleteThread(threadId, userDetails);
            deleteResponseDto.setRes(true);
            deleteResponseDto.setMsg("글 삭제가 완료되었습니다.");
        }catch (Exception e){
            deleteResponseDto.setRes(false);
            deleteResponseDto.setMsg(e.getMessage());
        }
        return deleteResponseDto;
    }
}
