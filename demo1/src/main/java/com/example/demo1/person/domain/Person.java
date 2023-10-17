package com.example.demo1.person.domain;
import jakarta.persistence.*;
import com.example.demo1.group.domain.Group;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "persons")

    private Set<Group> groups = new HashSet<>();

    public Person() {}

    public Person(Long id, String name, Set<Group> groups) {
        this.id = id;
        this.name = name;
        this.groups = groups;
    }


    // Getters y setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

}