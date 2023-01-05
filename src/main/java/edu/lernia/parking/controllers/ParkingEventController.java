package edu.lernia.parking.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping("/{id}")
  public ResponseEntity<Optional<ParkingEvent>> getParkingEventFromId(@PathVariable("id") Long id) {
    var event = parkingEventRepository.findById(id);
    if(event.isPresent()) {
      return ResponseEntity.ok().body(event);
    }
    return ResponseEntity.notFound().build();
  }
  
}
