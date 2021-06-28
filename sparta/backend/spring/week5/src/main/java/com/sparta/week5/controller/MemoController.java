package com.sparta.week5.controller;

import com.sparta.week5.model.Memo;
import com.sparta.week5.model.MemoDTO;
import com.sparta.week5.repository.MemoRepository;
import com.sparta.week5.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @GetMapping("/api/memos")
    public List<Memo> getMemos(){
        return memoRepository.findAllByOrderByModifiedAt();
    }

    @GetMapping("/api/memos/{id}")
    public Memo getMemo(@PathVariable Long id){
        return memoRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("%s 아이디의 메모가 없습니다.",id)));
    }

    @PostMapping("/api/memos")
    public Memo postMemos(@RequestBody MemoDTO memoDTO){
        return memoRepository.save(new Memo(memoDTO));
    }
}
