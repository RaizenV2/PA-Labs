package com.company;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {


    private final List<Person> persons = new ArrayList<>();
    public PersonController() {
        persons.add(new Person(1, "Anmdre",11));
        persons.add(new Person(2, "Damian",12));
    }

    @GetMapping
    public List<Person> getPersons() {
        return persons;
    }
    @GetMapping("/count")
    public int countPersons() {
        return persons.size();
    }
    @PostMapping
    public int createPerson(@RequestParam String name, Integer age) {
        int id = 1 + persons.size();
        persons.add(new Person(id, name,age));
        return id;
    }

    @PostMapping(value = "/obj", consumes="application/json")
    public ResponseEntity<String>
    createProduct(@RequestBody Person person) {
        persons.add(person);
        return new ResponseEntity<>(
                "Product created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update{id}")
    public ResponseEntity<String> updatePerson(
            @PathVariable int id, @RequestParam String name, Integer age) {
        Person person = findById(id).get();
        if (person == null) {
            return new ResponseEntity<>(
                    "Person not found", HttpStatus.NOT_FOUND); //or GONE
        }
        person.setName(name);
        person.setAge(age);
        return new ResponseEntity<>(
                "Person updated successsfully", HttpStatus.OK);
    }
    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable int id) {
        Person person = findById(id).get();
        if (person == null) {
            return new ResponseEntity<>(
                    "Product not found", HttpStatus.GONE);
        }
        persons.remove(person);
        return new ResponseEntity<>("Person removed", HttpStatus.OK);
    }
}