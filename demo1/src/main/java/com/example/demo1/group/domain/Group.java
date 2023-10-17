package com.example.demo1.group.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

import com.example.demo1.person.domain.Person;
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    
    @ManyToMany
    @JoinColumn(name = "group_id")
    private Set<Person> persons = new HashSet<>();

    public Group() {}

    public Group(Long id, String name, Set<Person> persons) {
        this.id = id;
        this.name = name;
        this.persons =persons;
    }


    // Getters y setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
}