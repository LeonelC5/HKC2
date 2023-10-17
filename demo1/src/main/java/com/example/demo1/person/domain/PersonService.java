package com.example.demo1.person.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.group.domain.Group;

import java.util.List;
import java.util.Set;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public Set<Group> getGroupsbyPerson(Long id) {
        return personRepository.findById(id).get().getGroups();
    }
}