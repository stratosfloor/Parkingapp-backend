package edu.lernia.parking.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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
  

}
