package com.sparta.week2.service;

import com.sparta.week2.domain.CourseRepository;
import com.sparta.week2.domain.CourseRequestDTO;
import com.sparta.week2.domain.Courses;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service // 스프링에게 이 클래스는 서비스임을 명시
public class CourseService {

    // final: 서비스에게 꼭 필요한 녀석임을 명시
    private final CourseRepository courseRepository;

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, CourseRequestDTO courseRequestDTO) {
        Courses course1 = courseRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("the id does not exist")
        );
        course1.update(courseRequestDTO);
        return course1.getId();
    }

    @Transactional
    public Long delete(Long id) throws IllegalArgumentException{
        courseRepository.deleteById(id);
        return id;
    }
}