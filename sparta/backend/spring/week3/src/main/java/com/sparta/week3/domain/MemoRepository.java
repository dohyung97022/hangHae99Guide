package com.sparta.week3.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByOrderByModifiedAtDesc();

    List<Memo> findAllByCreatedAtGreaterThanOrderByCreatedAtDesc(LocalDateTime localDateTime);
}
