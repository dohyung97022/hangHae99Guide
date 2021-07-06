package com.example.week7.controller;

import com.example.week7.dto.CommentDto;
import com.example.week7.dto.CreateCommentDto;
import com.example.week7.repository.CommentRepository;
import com.example.week7.security.UserDetailsImpl;
import com.example.week7.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CommentController {
    private final CommentService commentService;
    private final CommentRepository commentRepository;

    @Autowired
    public CommentController(CommentService commentService, CommentRepository commentRepository) {
        this.commentService = commentService;
        this.commentRepository = commentRepository;
    }

    @PostMapping("/comment")
    private String createComment(@AuthenticationPrincipal UserDetailsImpl userDetails, CreateCommentDto createCommentDto, RedirectAttributes redirectAttributes){
        try {
            commentService.createComment(createCommentDto,userDetails);
            redirectAttributes.addFlashAttribute("msg", "댓글이 저장되었습니다.");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("msg", e.getMessage());
        }
        return "redirect:/";
    }

    // 쓰레드 수정
    @PatchMapping(value = "/comment/{commentId}")
    public String editComment(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long commentId, CommentDto commentDto, RedirectAttributes redirectAttributes) {
        try {
            commentService.updateComment(commentDto, userDetails, commentId);
            redirectAttributes.addFlashAttribute("msg", "댓글이 수정되었습니다.");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("msg", e.getMessage());
        }
        return "redirect:/";
    }
}
