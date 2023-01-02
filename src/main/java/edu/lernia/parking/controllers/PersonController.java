package edu.lernia.parking.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.lernia.parking.entity.Person;
import edu.lernia.parking.repository.CarRepository;
import edu.lernia.parking.repository.PersonRepository;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

  PersonRepository personRepository;

  public PersonController(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @GetMapping()
  public Iterable<Person> getAllPersons() {
    return personRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Person>> getPersonById(@PathVariable("id") Long id) {
    var person = personRepository.findById(id);
    if(person.isPresent()) { 
      return ResponseEntity.ok().body(person);
    }
    return ResponseEntity.notFound().build();
  }
  

}
