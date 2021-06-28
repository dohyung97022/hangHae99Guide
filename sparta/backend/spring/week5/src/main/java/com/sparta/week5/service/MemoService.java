package com.sparta.week5.service;

import com.sparta.week5.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemoService {
    private final MemoRepository memoRepository;
}
