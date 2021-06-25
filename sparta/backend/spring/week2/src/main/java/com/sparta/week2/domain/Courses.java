package com.sparta.week2.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Courses extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String tutor;

    public Courses(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }

    public Courses(CourseRequestDTO courseRequestDTO){
        this.title = courseRequestDTO.getTitle();
        this.tutor = courseRequestDTO.getTutor();
    }

    public void update(CourseRequestDTO courseRequestDTO){
        this.title = courseRequestDTO.getTitle();
        this.tutor = courseRequestDTO.getTutor();
    }
}
