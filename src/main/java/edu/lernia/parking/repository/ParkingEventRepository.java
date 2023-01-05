package edu.lernia.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.lernia.parking.entity.ParkingEvent;

public interface ParkingEventRepository extends CrudRepository<ParkingEvent, Long> {

  @Override
  List<ParkingEvent> findAll();
  
  List<ParkingEvent> findParkingEventsByCarId(Long id);

  List<ParkingEvent> findParkingEventsByPersonId(Long id);

  @Query("""
      SELECT p from ParkingEvent p WHERE p.car.person.id = :personId AND p.active =:active
      """)
  List<ParkingEvent> findAllParkingEventsByPersonIdAndActive(@Param("personId") Long personId, @Param("active") Boolean active);


}
