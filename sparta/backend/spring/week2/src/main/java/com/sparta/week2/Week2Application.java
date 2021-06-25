package com.sparta.week2;

import com.sparta.week2.domain.CourseRepository;
import com.sparta.week2.domain.CourseRequestDTO;
import com.sparta.week2.domain.Courses;
import com.sparta.week2.service.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class Week2Application {

    public static void main(String[] args) {
        SpringApplication.run(Week2Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CourseRepository courseRepository, CourseService courseService) {
        return (args) -> {
            // 데이터 저장하기
            courseRepository.save(new Courses("프론트엔드의 꽃, 리액트", "임민영"));

            // 데이터 전부 조회하기
            List<Courses> courseList = courseRepository.findAll();
            for (Courses course : courseList) {
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }

            // 데이터 하나 조회하기
            Courses course = courseRepository.findById(1L).orElseThrow(
                    () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
            );

            // 데이터 업데이트하기
            CourseRequestDTO courseRequestDTO = new CourseRequestDTO("스프링 봄", "조만석");
            courseService.update(1L, courseRequestDTO);

        };
    }
}
