package edu.lernia.parking.service;

import org.springframework.stereotype.Service;

import edu.lernia.parking.repository.ParkingEventRepository;
import jakarta.transaction.Transactional;

@Service
public class ParkingEventService {
  
  private final ParkingEventRepository parkingEventRepository;

    public ParkingEventService(ParkingEventRepository parkingEventRepository) {
        this.parkingEventRepository = parkingEventRepository;
    }

    @Transactional
    public void updateStopTime(Long  id, Long minutes) {
      parkingEventRepository
        .findById(id) 
        .ifPresent(event1 -> {
          event1.setStopTime(event1.getStopTime().plusMinutes(Math.abs(minutes)));
          parkingEventRepository.save(event1);
        });
    }
}
