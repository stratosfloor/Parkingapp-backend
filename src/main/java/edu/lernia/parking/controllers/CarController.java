package edu.lernia.parking.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
