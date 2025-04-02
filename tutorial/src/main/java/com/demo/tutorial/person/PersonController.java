package com.demo.tutorial.person;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.print.attribute.standard.PresentationDirection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/people")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllPeople() {
        List<Person> lista = personService.getAll();
        if (lista.isEmpty()) {
            return new ResponseEntity<String>("lista vuota", HttpStatus.OK);
        }
        return new ResponseEntity<List<Person>>(lista, HttpStatus.OK);
    }

    @PostMapping("/add-person")
    public ResponseEntity<String> addPerson(@RequestBody Person person) {
        System.out.println(person);
        personService.savePerson(person);
        return ResponseEntity.ok("persona aggiunta!");
    }

    @PostMapping("/add-people")
    public ResponseEntity<String> addPeople(@RequestBody List<Person> people) {
        System.out.println(people);
        personService.saveAll(people);
        return ResponseEntity.ok("persone aggiunte!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getPersonById(@PathVariable Long id) {
        Person p = personService.getPersonPerId(id);
        if (p == null)
            return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok("person found : " + p);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
        Person p = personService.getPersonPerId(id);
        if (p == null) {

            return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
        }
        personService.updatePerson(id, personDTO);
        return ResponseEntity.ok("updated person " + id + " with new values !");
    }

}
