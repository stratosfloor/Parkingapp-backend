package edu.lernia.parking.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.lernia.parking.entity.ParkingEvent;
import edu.lernia.parking.repository.ParkingEventRepository;

@RestController
@RequestMapping("/api/parkingevents")
public class ParkingEventController {

  ParkingEventRepository parkingEventRepository;

  public ParkingEventController(ParkingEventRepository parkingEventRepository) {
    this.parkingEventRepository = parkingEventRepository;
  }


  @GetMapping()
  public List<ParkingEvent> getAllParkingEvents() {
    return parkingEventRepository.findAll();
  }
  
}
