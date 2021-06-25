package com.sparta.week2.controller;

import com.sparta.week2.domain.Person;
import com.sparta.week2.domain.PersonRepository;
import com.sparta.week2.domain.PersonRequestDTO;
import com.sparta.week2.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PersonController {

    private final PersonService personService;
    private final PersonRepository personRepository;

    @GetMapping("/api/persons")
    public List<Person> getPersons(){
        return personRepository.findAll();
    }

    @PostMapping("/api/persons")
    public Person createPerson(@RequestBody PersonRequestDTO personRequestDTO){
        return personService.create(personRequestDTO);
    }

    @PutMapping("/api/persons/{id}")
    public Long putPerson(@PathVariable Long id,@RequestBody PersonRequestDTO personRequestDTO){
        return personService.update(id, personRequestDTO);
    }

    @DeleteMapping("/api/persons/{id}")
    public Long deletePerson(@PathVariable Long id){
        return personService.delete(id);
    }
}
