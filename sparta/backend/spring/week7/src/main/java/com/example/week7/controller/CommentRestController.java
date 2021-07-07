package com.example.week7.controller;

import com.example.week7.dto.DeleteResponseDto;
import com.example.week7.security.UserDetailsImpl;
import com.example.week7.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentRestController {
    private final CommentService commentService;

    @Autowired
    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(value = "/comment/{commentId}", method = RequestMethod.DELETE)
    public DeleteResponseDto deleteComment(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long commentId){
        DeleteResponseDto deleteResponseDto = new DeleteResponseDto();
        if (userDetails != null){
            deleteResponseDto.setLoggedIn(true);
        }
        try {
            commentService.deleteComment(commentId, userDetails);
            deleteResponseDto.setRes(true);
            deleteResponseDto.setMsg("댓글 삭제가 완료되었습니다.");
        }catch (Exception e){
            deleteResponseDto.setRes(false);
            deleteResponseDto.setMsg(e.getMessage());
        }
        return deleteResponseDto;
    }
}
