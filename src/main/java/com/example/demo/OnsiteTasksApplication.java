package com.example.demo;

import java.awt.Color;
import java.sql.Date;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

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
//		ConfigurableApplicationContext confAppContext = SpringApplication.run(OnsiteTasksApplication.class, args);
//		Car car = confAppContext.getBean(Car.class);
//		System.out.println(car);
	}

	@Bean
	public CommandLineRunner test(PersonRepository repo) {
		return (args) -> {
			repo.save(new Person("Jack", "Bauer", Date.valueOf("1975-06-02")));
			repo.save(new Person("Jack", "Ryan", Date.valueOf("1982-09-06")));
		};
	}

	@Bean
	public CommandLineRunner demo(CarRepository repo) {
		CommandLineRunner cmd = new CommandLineRunner() {

			@Override
			@Transactional
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub

//				Person jackBauer = new Person("Jack", "Bauer", Date.valueOf("1975-06-02"));
				Car mazda = new Car("MAZDA", Color.BLACK, "MX-5", "Jack", false);
				repo.save(mazda);
				repo.save(new Car("MAZDA", Color.yellow, "Mazda-3", "Ryan", true));
				log.info("findAll");
				for (Car car : repo.findAll()) {
					log.info(car.toString());
				}
				log.info("___");

//				log.info("findById");
//				log.info(repo.findById(2L).get().toString());
//				log.info("___");

				log.info("findByColour");
				for (Car car : repo.findByColour(Color.BLACK)) {
					log.info(car.toString());
				}
				log.info("___");

				log.info("findByOwner");
				log.info(repo.findByOwner("Jack").toString());

				log.info("findByNameAndOwner");
				for (Car car : repo.findByNameAndOwner("MAZDA", "Jack")) {
					log.info(car.toString());
				}

				log.info("findByNameSorted");
				for (Car car : repo.findByName("MAZDA", Sort.by(Sort.Direction.DESC, "model"))) {
					log.info(car.toString());
				}

				log.info("" + repo.deleteByOwner("Jack"));

				log.info("delete done");

			}
		};

//		cmd =
		new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				CarService cService = new CarService();
				cService.setRepo(repo);

				log.info("adding a car");

				cService.addCar("name", Color.yellow, "modle", "owner", false);

				log.info("retrieving cars");

				for (Car car : cService.getRepo().findAll()) {
					log.info(car.toString());
				}

				log.info("updating a car");

				cService.updateCarColour(2L, Color.red);

				for (Car car : cService.getRepo().findByColour(Color.red)) {
					log.info(car.toString());
				}
			}

		};

		return cmd;
	}

}
