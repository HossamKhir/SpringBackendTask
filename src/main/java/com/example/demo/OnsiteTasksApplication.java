package com.example.demo;

import java.awt.Color;
import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * used the following tutorial:
 * 
 * https://spring.io/guides/gs/accessing-data-jpa/#initial
 * 
 * @author khair
 *
 */
@SpringBootApplication
public class OnsiteTasksApplication {

	private final static Logger log = LoggerFactory.getLogger(OnsiteTasksApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OnsiteTasksApplication.class);
	}

	@Bean
	public CommandLineRunner demo(PersonRepository personRepo, CarRepository carRepo) {
		CommandLineRunner cmd = new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				personRepo.save(new Person("Jack", "Bauer", Date.valueOf("1975-06-02")));
				personRepo.save(new Person("Jason", "Bourne", Date.valueOf("1970-09-25")));
				personRepo.save(new Person("James", "Bond", Date.valueOf("1948-11-06")));
				personRepo.save(new Person("John", "Wick", Date.valueOf("1982-02-01")));
				personRepo.save(new Person("Hossam", "Khairullah", Date.valueOf("1995-05-02")));

				carRepo.save(
						new Car("BUGATTI", Color.white, "Chiron", personRepo.findBySurname("Bauer").get(0), false));
				carRepo.save(
						new Car("HONDA", Color.cyan, "NSX 1991", personRepo.findByFirstName("Jason").get(0), false));
				carRepo.save(new Car("VOLKSWAGEN", Color.red, "Beetle", personRepo.findBySurname("Khairullah").get(0),
						true));
				carRepo.save(new Car("ASTON MARTIN", Color.gray, "DB11", personRepo.findById(3L).get(0), false));
				carRepo.save(new Car("FORD", Color.blue, "Shelby Mustang 2013", personRepo.findBySurname("Wick").get(0),
						false));

				log.info("test-->");
				log.info("findById");
				log.info(carRepo.findById(2L).get().toString());

				log.info("findByName");
				for (Car car : carRepo.findByName("FORD")) {
					log.info(car.toString());
				}

				log.info("findByColor");
				for (Car car : carRepo.findByColour(Color.red)) {
					log.info(car.toString());
				}

				log.info("findByModel");
				for (Car car : carRepo.findByModel("DB11")) {
					log.info(car.toString());
				}

				log.info("findByOwner");
				log.info(carRepo.findByOwner(personRepo.findBySurname("Bourne").get(0)).toString());

			}
		};
		return cmd;
	}

}
