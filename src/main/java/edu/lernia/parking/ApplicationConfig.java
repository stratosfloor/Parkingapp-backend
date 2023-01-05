package edu.lernia.parking;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.geolatte.geom.json.GeolatteGeomModule;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.lernia.parking.entity.Person;
import edu.lernia.parking.entity.Car;
import edu.lernia.parking.entity.ParkingEvent;
import edu.lernia.parking.entity.ParkingLot;
import edu.lernia.parking.repository.CarRepository;
import edu.lernia.parking.repository.ParkingEventRepository;
import edu.lernia.parking.repository.ParkingLotRepository;
import edu.lernia.parking.repository.PersonRepository;

import static org.geolatte.geom.builder.DSL.*;
import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;

@Configuration
public class ApplicationConfig {

  @Bean
  GeolatteGeomModule geolatteModule(){
    return new GeolatteGeomModule();
 }

  
  
  @Bean
  CommandLineRunner init(
    PersonRepository personRepository, 
    CarRepository carRepository, 
    ParkingLotRepository parkingLotRepository, 
    ParkingEventRepository parkingEventRepository) {
      return args -> {

        Person p1 = new Person();
        p1.setFirstName("Canilla");
        p1.setLastName("Kiwson");
        personRepository.save(p1);

        Person p2 = new Person();
        p2.setFirstName("Enil");
        p2.setLastName("Kiwson");
        personRepository.save(p2);

        Car car1 = new Car();
        car1.setRegnr("LMA714");
        car1.setPerson(p1);
        carRepository.save(car1);

        Car car2 = new Car();
        car2.setRegnr("ABC123");
        car2.setPerson(p1);
        carRepository.save(car2);

        Car car3 = new Car();
        car3.setRegnr("HPB857");
        car3.setPerson(p2);
        carRepository.save(car3);

        ParkingLot pl1 = new ParkingLot();
        pl1.setName("Nanna");
        Point<G2D> po1 = point(WGS84,g(123, 123));
        pl1.setCordinates(po1);
        parkingLotRepository.save(pl1);

        ParkingLot pl2 = new ParkingLot();
        pl2.setName("Örnen");
        Point<G2D> po2 = point(WGS84,g(234, 234));
        pl2.setCordinates(po2);
        parkingLotRepository.save(pl2);

        ParkingEvent pe1 = new ParkingEvent();
        pe1.setPerson(p1);
        pe1.setCar(car1);
        pe1.setParkingLot(pl1);
        parkingEventRepository.save(pe1);

        ParkingEvent pe2 = new ParkingEvent();
        pe2.setPerson(p1);
        pe2.setCar(car2);
        pe2.setParkingLot(pl1);
        parkingEventRepository.save(pe2);

        ParkingEvent pe3 = new ParkingEvent();
        pe3.setPerson(p2);
        pe3.setCar(car3);
        pe3.setParkingLot(pl2);
        parkingEventRepository.save(pe3);
        
      };
  }
}
