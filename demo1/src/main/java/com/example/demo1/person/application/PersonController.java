package com.example.demo1.person.application;
import com.example.demo1.group.domain.Group;
import com.example.demo1.person.domain.Person;
import com.example.demo1.person.domain.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;
@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        return ResponseEntity.ok(personService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> person(@PathVariable Long id) {
        Person person = personService.findById(id);
        return ResponseEntity.status(200).body(person);
    }

    @GetMapping("/groups/{id}")
    public ResponseEntity<Set<Group>> getGroupsByPersonId(@PathVariable Long id) {
        Set<Group> groups = personService.getGroupsbyPerson(id);
        return ResponseEntity.ok(groups);
    }
}
