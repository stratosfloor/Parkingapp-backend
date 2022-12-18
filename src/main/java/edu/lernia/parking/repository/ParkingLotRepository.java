package edu.lernia.parking.repository;

import org.springframework.data.repository.CrudRepository;

import edu.lernia.parking.entity.ParkingLot;

public interface ParkingLotRepository extends CrudRepository<ParkingLot, Long>{}