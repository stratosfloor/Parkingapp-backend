package edu.lernia.parking.controllers;

import java.util.List;
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
import edu.lernia.parking.entity.ParkingEvent;
import edu.lernia.parking.repository.CarRepository;
import edu.lernia.parking.repository.ParkingEventRepository;

@RestController
@RequestMapping("/api/cars")
public class CarController {
  CarRepository carRepository;
  ParkingEventRepository parkingEventRepository;

  public CarController(CarRepository carRepository, ParkingEventRepository parkingEventRepository) {
    this.carRepository = carRepository;
    this.parkingEventRepository = parkingEventRepository;
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

  @PostMapping()
  public ResponseEntity<Car> addNewCar(@RequestBody Car car) {
    if (car.getPerson() == null) {
      return ResponseEntity.badRequest().build();
    }
    var c = carRepository.save(car);
    return ResponseEntity
      .created(ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(c.getId())
      .toUri())
      .body(c);
  }

  @GetMapping("/{id}/parkingevents")
  public List<ParkingEvent> getACarsParkingEvent(@PathVariable("id") Long id) {
    return parkingEventRepository.findParkingEventsByCarId(id);
  }
}
