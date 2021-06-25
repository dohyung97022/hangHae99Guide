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
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    public Person(PersonRequestDTO personDTO){
        this.name = personDTO.getName();
    }

    public void update(PersonRequestDTO personRequestDTO){
        this.name = personRequestDTO.getName();
    }
}
