package com.example.temat1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonRestController {

    private final PersonService personService;

    @Autowired
    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getPeople() {
        List<Person> people = personService.getPeople();
        return ResponseEntity.ok(people);
    }

    @GetMapping("/{index}")
    public ResponseEntity<Person> getPerson(@PathVariable int index) {
        try {
            Person person = personService.getPerson(index);
            return ResponseEntity.ok(person);
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<String> addPerson(@RequestBody Person person) {
        personService.addPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body("Person added successfully");
    }

    @PutMapping("/{index}")
    public ResponseEntity<String> updatePerson(@PathVariable int index, @RequestBody Person updatedPerson) {
        try {
            personService.setPerson(index, updatedPerson);
            return ResponseEntity.ok("Person updated successfully");
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found");
        }
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<String> removePerson(@PathVariable int index) {
        try {
            personService.removePerson(index);
            return ResponseEntity.ok("Person removed successfully");
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found");
        }
    }
}
