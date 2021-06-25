package com.sparta.week1.controller;

import com.sparta.week1.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/persons")
    public Person getCourses() {
        Person person = new Person();
        person.setName("김도형");
        person.setJob("취준생");
        person.setAge(25);
        person.setAddress("영동대로 210 5동 203호");
        return person;
    }
}