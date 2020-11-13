package com.example.demo;

import java.awt.Color;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

	/**
	 * 
	 * @param owner
	 * @return
	 */
	Car findByOwner(String owner);

	/**
	 * 
	 * @param name
	 * @return
	 */
	List<Car> findByName(String name);

	/**
	 * 
	 * @param model
	 * @return
	 */
	List<Car> findByModel(String model);

	/**
	 * 
	 * @param id
	 * @return
	 */
//	Car findById(long id);

	/**
	 * 
	 * @param colour
	 * @return
	 */
	List<Car> findByColour(Color colour);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	long deleteByOwner(String owner);

}
