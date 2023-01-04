package edu.lernia.parking.repository;

import org.springframework.data.repository.CrudRepository;

import edu.lernia.parking.entity.ParkingEvent;

public interface ParkingEventRepository extends CrudRepository<ParkingEvent, Long> {
  
}
