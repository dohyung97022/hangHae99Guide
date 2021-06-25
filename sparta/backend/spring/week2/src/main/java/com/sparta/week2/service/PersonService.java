package com.sparta.week2.service;

import com.sparta.week2.domain.Person;
import com.sparta.week2.domain.PersonRequestDTO;
import com.sparta.week2.domain.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PersonService {
    private final PersonRepository personRepository;

    public Person create(PersonRequestDTO personRequestDTO){
        return personRepository.save(new Person(personRequestDTO));
    }

    public Long update(Long id, PersonRequestDTO personRequestDTO){
        Person person = personRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("id does not exist"));
        person.update(personRequestDTO);
        return person.getId();
    }

    public Long delete(Long id) throws IllegalArgumentException{
        personRepository.deleteById(id);
        return id;
    }
}
