package com.example.week7.service;

import com.example.week7.domain.Thread;
import com.example.week7.dto.CreateThreadDto;
import com.example.week7.repository.ThreadRepository;
import com.example.week7.security.UserDetailsImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThreadService {
    private ThreadRepository threadRepository;

    @Autowired
    public ThreadService(ThreadRepository threadRepository) {
        this.threadRepository = threadRepository;
    }

    public void createThread(@NotNull CreateThreadDto createThreadDto, UserDetailsImpl userDetails) {
        if (userDetails == null){
            throw new IllegalArgumentException("로그인되어 있지 않습니다.");
        }
        Thread thread = new Thread(userDetails.getUser(), createThreadDto.getTitle(), createThreadDto.getContent());
        threadRepository.save(thread);
    }
}
