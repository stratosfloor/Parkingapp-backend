package edu.lernia.parking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 6)
    private String regnr;

    private Person owner;


    // Constructor
    public Car(){}


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getRegnr() {
        return regnr;
    }


    public void setRegnr(String regnr) {
        this.regnr = regnr;
    }


    public Person getOwner() {
        return owner;
    }


    public void setOwner(Person owner) {
        this.owner = owner;
    }

    

}