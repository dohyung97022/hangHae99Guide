package com.example.week7.service;

import com.example.week7.domain.Comment;
import com.example.week7.domain.Thread;
import com.example.week7.dto.CommentDto;
import com.example.week7.dto.CreateCommentDto;
import com.example.week7.repository.CommentRepository;
import com.example.week7.repository.ThreadRepository;
import com.example.week7.security.UserDetailsImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ThreadRepository threadRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, ThreadRepository threadRepository) {
        this.commentRepository = commentRepository;
        this.threadRepository = threadRepository;
    }

    public void createComment(@NotNull CreateCommentDto createCommentDto, UserDetailsImpl userDetails){
        if (userDetails == null){
            throw new IllegalArgumentException("로그인되어 있지 않습니다.");
        }
        if (createCommentDto.getContent().equals("")){
            throw new IllegalArgumentException("댓글의 내용이 없습니다.");
        }
        Thread thread = threadRepository.getById(createCommentDto.getThreadId());
        Comment comment = new Comment(userDetails.getUser(), thread, createCommentDto.getContent());
        commentRepository.save(comment);
    }

    public void updateComment(CommentDto commentDto, UserDetailsImpl userDetails, Long commentId) {
        if (userDetails == null){
            throw new IllegalArgumentException("로그인되어 있지 않습니다.");
        }
        Comment comment = commentRepository.getById(commentId);
        if (!comment.getUser().getId().equals(userDetails.getUser().getId())){
            throw new IllegalCallerException("해당 댓글을 수정할 권한이 없습니다.");
        }
        if (commentDto.getContent().equals("")){
            throw new IllegalArgumentException("댓글의 내용이 없습니다.");
        }
        comment.setContent(commentDto.getContent());
        commentRepository.save(comment);
    }

    public void deleteComment(Long commentId, UserDetailsImpl userDetails){
        if (userDetails == null){
            throw new IllegalArgumentException("로그인이 필요한 기능입니다.");
        }
        // user 가 만든 comment 인지 확인
        Long loggedInId = userDetails.getUser().getId();
        Long commentUserId = commentRepository.getById(commentId).getUser().getId();
        if (!loggedInId.equals(commentUserId)){
            throw new IllegalCallerException("해당 댓글을 삭제할 권한이 없습니다.");
        }
        commentRepository.deleteById(commentId);
    }
}
