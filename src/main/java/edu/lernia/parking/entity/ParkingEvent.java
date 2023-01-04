package edu.lernia.parking.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class ParkingEvent {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Person person;

  @OneToOne
  private Car car;

  @OneToOne
  private ParkingLot parkingLot;
  
  private LocalDateTime startTime = LocalDateTime.now();
  private LocalDateTime stopTime;
  private Boolean active=true;


  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public Person getPerson() {
    return person;
  }
  public void setPerson(Person person) {
    this.person = person;
  }
  public Car getCar() {
    return car;
  }
  public void setCar(Car car) {
    this.car = car;
  }
  public ParkingLot getParkingLot() {
    return parkingLot;
  }
  public void setParkingLot(ParkingLot parkingLot) {
    this.parkingLot = parkingLot;
  }
  public LocalDateTime getStartTime() {
    return startTime;
  }
  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }
  public LocalDateTime getStopTime() {
    return stopTime;
  }
  public void setStopTime(LocalDateTime stopTime) {
    this.stopTime = stopTime;
  }
  public Boolean getActive() {
    return active;
  }
  public void setActive(Boolean active) {
    this.active = active;
  }
  
}
