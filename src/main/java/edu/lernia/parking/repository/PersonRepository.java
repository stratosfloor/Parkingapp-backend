package edu.lernia.parking.repository;

import org.springframework.data.repository.CrudRepository;

import edu.lernia.parking.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{
    
}
