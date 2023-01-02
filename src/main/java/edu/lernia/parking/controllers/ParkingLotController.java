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

import edu.lernia.parking.entity.ParkingLot;
import edu.lernia.parking.repository.ParkingLotRepository;

@RestController
@RequestMapping("/api/lots")
public class ParkingLotController {
  
  ParkingLotRepository parkingLotRepository;

  public ParkingLotController(ParkingLotRepository parkingLotRepository) {
    this.parkingLotRepository = parkingLotRepository;
  }

  @GetMapping()
  public Iterable<ParkingLot> getAllParkingLots() {
    return parkingLotRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<ParkingLot>> getParkingLotById(@PathVariable("id") Long id) {
    var lot = parkingLotRepository.findById(id);
    if(lot.isPresent()) {
      return ResponseEntity.ok().body(lot);
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<ParkingLot> createNewParkingLot(@RequestBody ParkingLot parkinglot) {
    var p = parkingLotRepository.save(parkinglot);
    return ResponseEntity
      .created(ServletUriComponentsBuilder
      .fromCurrentRequest()
      .buildAndExpand(p.getId())
      .toUri())
      .body(p);
  }
  
}
