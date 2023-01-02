package edu.lernia.parking.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.lernia.parking.entity.ParkingLot;
import edu.lernia.parking.repository.ParkingLotRepository;

@RestController
@RequestMapping("/api/lots")
public class ParkingLotController {
  
  ParkingLotRepository parkingLotRepository;

  public ParkingLotController(ParkingLotRepository parkingLotRepository) {
    this.parkingLotRepository = parkingLotRepository;
  }

  @GetMapping
  public Iterable<ParkingLot> getAllParkingLots() {
    return parkingLotRepository.findAll();
  }
  
}
