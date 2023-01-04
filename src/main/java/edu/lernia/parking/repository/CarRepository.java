package edu.lernia.parking.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.lernia.parking.entity.Car;

public interface CarRepository extends CrudRepository<Car, Long>{

  List<Car> findCarsByPersonId(Long id);
}
