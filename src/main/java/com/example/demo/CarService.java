package com.example.demo;

import java.awt.Color;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

	@Autowired
	private CarRepository repo;

	public CarService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param name
	 * @param colour
	 * @param model
	 * @param owner
	 * @param hideMe
	 */
	public void addCar(String name, Color colour, String model, Person owner, boolean hideMe) {
		Car car = new Car(name, colour, model, owner, hideMe);
		repo.save(car);
	}

	/**
	 * 
	 * @param id
	 * @param name
	 */
	public void updateCarName(long id, String name) {
		Car car;
		Optional<Car> oCar = repo.findById(id);
		if (oCar.isPresent()) {
			car = oCar.get();
		} else {
			return;
		}
		car.setName(name);
		repo.save(car);
	}

	/**
	 * 
	 * @param id
	 * @param colour
	 */
	public void updateCarColour(long id, Color colour) {
		Car car = repo.findById(id).get();
		car.setColour(colour);
		repo.save(car);
	}

	/**
	 * 
	 * @param id
	 * @param model
	 */
	public void updateCarModel(long id, String model) {
		Car car = repo.findById(id).get();
		car.setModel(model);
		repo.save(car);
	}

	/**
	 * 
	 * @param id
	 * @param owner
	 */
	public void updateCarOwner(long id, Person owner) {
		Car car = repo.findById(id).get();
		car.setOwner(owner);
		repo.save(car);
	}

	/**
	 * 
	 * @param id
	 * @param hideMe
	 */
	public void updateCarHideMe(long id, boolean hideMe) {
		Car car = repo.findById(id).get();
		car.setHideMe(hideMe);
		repo.save(car);
	}

}
