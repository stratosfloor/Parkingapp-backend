package edu.lernia.parking.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.lernia.parking.entity.Car;
import edu.lernia.parking.repository.CarRepository;

@RestController
@RequestMapping("/api/cars")
public class CarController {
  CarRepository carRepository;

  public CarController(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  @GetMapping()
  public Iterable<Car> getAllCars() {
    return carRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Car>> getCarById(@PathVariable("id") Long id) {
    var car = carRepository.findById(id);
    if(car.isPresent()) {
      return ResponseEntity.ok().body(car);
    }
    return ResponseEntity.notFound().build();
  }


}
