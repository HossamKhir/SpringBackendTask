package com.example.demo;

import java.awt.Color;

public class CarService {

	private CarRepository repo;

	public CarService() {
		// TODO Auto-generated constructor stub
	}

	public CarRepository getRepo() {
		return repo;
	}

	public void setRepo(CarRepository repo) {
		this.repo = repo;
	}

	public void addCar(Car car) {
		repo.save(car);
	}
	
	public void addCar(String name, Color colour, String model, String owner, boolean hideMe) {
		Car car = new Car(name, colour, model, owner, hideMe);
		repo.save(car);
	}
	
	public void updateCarName(long id, String name) {
		Car car = repo.findById(id).get();
		car.setName(name);
		repo.save(car);
	}
	
	public void updateCarColour(long id, Color colour) {
		Car car = repo.findById(id).get();
		car.setColour(colour);
		repo.save(car);
	}
	
	public void updateCarModel(long id, String model) {
		Car car = repo.findById(id).get();
		car.setModel(model);
		repo.save(car);
	}

	public void updateCarOwner(long id, String owner) {
		Car car = repo.findById(id).get();
		car.setOwner(owner);
		repo.save(car);
	}
	
	public void updateCarHideMe(long id, boolean hideMe) {
		Car car = repo.findById(id).get();
		car.setHideMe(hideMe);
		repo.save(car);
	}
}
