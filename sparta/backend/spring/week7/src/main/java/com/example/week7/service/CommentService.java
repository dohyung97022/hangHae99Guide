package com.example.week7.service;

import com.example.week7.domain.Comment;
import com.example.week7.domain.Thread;
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
        Thread thread = threadRepository.getById(createCommentDto.getThreadId());
        Comment comment = new Comment(userDetails.getUser(), thread, createCommentDto.getContent());
        commentRepository.save(comment);
    }
}
