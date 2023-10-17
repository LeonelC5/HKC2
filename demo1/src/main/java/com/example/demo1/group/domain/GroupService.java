package com.example.demo1.group.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.person.domain.Person;
import com.example.demo1.person.domain.PersonService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private PersonService personService;

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public Optional<Group> findById(Long id) {
        return groupRepository.findById(id);
    }

    public Group save(Group group) {
        return groupRepository.save(group);
    }

    public Set<Person> getGroupPersons(Long id) {
        return groupRepository.findById(id).orElse(null).getPersons();
    }

    public Group addPersonToGroup(Long id, Long personId) {
        Group group = groupRepository.findById(id).orElse(null);
        if (group != null) {
            group.getPersons().add(personService.findById(personId));
            return groupRepository.save(group);
        } else {
            return null;
        }
    }
}