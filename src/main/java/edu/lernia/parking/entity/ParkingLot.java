package edu.lernia.parking.entity;


import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ParkingLot {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    private Point<G2D> cordinates;



    // Constructor
    public ParkingLot() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public Point<G2D> getCordinates() {
        return cordinates;
    }

    public void setCordinates(Point<G2D> cordinates) {
        this.cordinates = cordinates;
    }
    
}
