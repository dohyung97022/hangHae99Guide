package com.example.week7.service;

import com.example.week7.domain.Comment;
import com.example.week7.domain.Thread;
import com.example.week7.dto.ThreadDto;
import com.example.week7.repository.CommentRepository;
import com.example.week7.repository.ThreadRepository;
import com.example.week7.security.UserDetailsImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreadService {
    private final ThreadRepository threadRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public ThreadService(ThreadRepository threadRepository, CommentRepository commentRepository) {
        this.threadRepository = threadRepository;
        this.commentRepository = commentRepository;
    }

    public void createThread(@NotNull ThreadDto threadDto, UserDetailsImpl userDetails) {
        if (userDetails == null){
            throw new IllegalArgumentException("로그인되어 있지 않습니다.");
        }
        if (threadDto.getTitle().equals("")){
            throw new IllegalArgumentException("글의 제목이 없습니다.");
        }
        if (threadDto.getContent().equals("")){
            throw new IllegalArgumentException("글의 내용이 없습니다.");
        }
        Thread thread = new Thread(userDetails.getUser(), threadDto.getTitle(), threadDto.getContent());
        threadRepository.save(thread);
    }

    public void updateThread(ThreadDto threadDto, UserDetailsImpl userDetails, Long threadId) {
        if (userDetails == null){
            throw new IllegalArgumentException("로그인되어 있지 않습니다.");
        }
        Thread thread = threadRepository.getById(threadId);
        if (!thread.getUser().getId().equals(userDetails.getUser().getId())){
            throw new IllegalCallerException("해당 글을 수정할 권한이 없습니다.");
        }
        if (threadDto.getTitle().equals("")){
            throw new IllegalArgumentException("글의 제목이 없습니다.");
        }
        if (threadDto.getContent().equals("")){
            throw new IllegalArgumentException("글의 내용이 없습니다.");
        }
        thread.setTitle(threadDto.getTitle());
        thread.setContent(threadDto.getContent());
        threadRepository.save(thread);
    }

    public void deleteThread(Long threadId, UserDetailsImpl userDetails){
        if (userDetails == null){
            throw new IllegalArgumentException("로그인이 필요한 기능입니다.");
        }
        // user 가 만든 thread 인지 확인
        Long loggedInId = userDetails.getUser().getId();
        Long threadUserId = threadRepository.getById(threadId).getUser().getId();
        if (!loggedInId.equals(threadUserId)){
            throw new IllegalCallerException("해당 글을 삭제할 권한이 없습니다.");
        }
        // 모든 thread 의 댓글을 삭제
        List<Comment> threadComments = commentRepository.findAllByThreadId(threadId);
        commentRepository.deleteAll(threadComments);
        threadRepository.deleteById(threadId);
    }
}
