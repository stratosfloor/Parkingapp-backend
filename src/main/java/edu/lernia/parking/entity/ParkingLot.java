package edu.lernia.parking.entity;

import org.springframework.data.geo.Point;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ParkingLot {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Point cordinates;

    // Constructor
    public ParkingLot() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Point getCordinates() {
        return cordinates;
    }

    public void setCordinates(Point cordinates) {
        this.cordinates = cordinates;
    }

    
}
