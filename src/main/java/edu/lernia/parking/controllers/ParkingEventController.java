package edu.lernia.parking.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.lernia.parking.entity.ParkingEvent;
import edu.lernia.parking.repository.ParkingEventRepository;
import edu.lernia.parking.service.ParkingEventService;

@RestController
@RequestMapping("/api/parkingevents")
public class ParkingEventController {

  ParkingEventRepository parkingEventRepository;
  ParkingEventService parkingEventService;

  public ParkingEventController(ParkingEventRepository parkingEventRepository, ParkingEventService parkingEventService) {
    this.parkingEventRepository = parkingEventRepository;
    this.parkingEventService = parkingEventService;
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

  @PatchMapping(path = "/{id}")
  public void updateStopTimeForParkingEvent(@PathVariable("id") Long id, @RequestParam Long addMinutes) {
    parkingEventService.updateStopTime(id, addMinutes);
  }
  
}
