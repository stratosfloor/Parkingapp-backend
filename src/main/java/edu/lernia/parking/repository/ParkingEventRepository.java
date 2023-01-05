package edu.lernia.parking.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.lernia.parking.entity.ParkingEvent;

public interface ParkingEventRepository extends CrudRepository<ParkingEvent, Long> {

  @Override
  List<ParkingEvent> findAll();
  
  List<ParkingEvent> findParkingEventsByCarId(Long id);
}
