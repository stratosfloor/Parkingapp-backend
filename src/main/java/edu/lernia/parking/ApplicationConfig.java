package edu.lernia.parking;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.lernia.parking.entity.Person;
import edu.lernia.parking.entity.Car;
import edu.lernia.parking.repository.CarRepository;
import edu.lernia.parking.repository.PersonRepository;

@Configuration
public class ApplicationConfig {
  
  
  @Bean
  CommandLineRunner init(PersonRepository personRepository, CarRepository carRepository) {
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
      };
  }
}
