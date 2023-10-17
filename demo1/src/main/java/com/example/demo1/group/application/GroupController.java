package com.example.demo1.group.application;
import com.example.demo1.group.domain.Group;
import com.example.demo1.group.domain.GroupService;
import com.example.demo1.person.domain.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping
    public ResponseEntity<List<Group>> getAllGroup() {
        return ResponseEntity.ok(groupService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Group>> group(@PathVariable Long id) {
        Optional<Group> group = groupService.findById(id);
        return ResponseEntity.status(200).body(group);
    }
    @GetMapping("/persons/{id}")
    public ResponseEntity<Set<Person>> getPersonsByGroupId(@PathVariable Long id) {
        Set<Person> persons = groupService.getGroupPersons(id);
        return ResponseEntity.ok(persons);
    }
}