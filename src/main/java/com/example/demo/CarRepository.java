package com.example.demo;

import java.awt.Color;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

	/**
	 * 
	 * @param owner
	 * @return
	 */
	Car findByOwner(Person owner);

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
	 * found solution here:
	 * 
	 * https://www.baeldung.com/spring-data-jpa-delete
	 */

	/**
	 * 
	 * @param name
	 * @return
	 */
	long deleteByName(String name);

	/**
	 * 
	 * @param model
	 * @return
	 */
	long deleteByModel(String model);

	/**
	 * 
	 * @param colour
	 * @return
	 */
	long deleteByColour(Color colour);

	/**
	 * 
	 * @param owner
	 * @return
	 */
	long deleteByOwner(Person owner);
	
	/**
	 * updates found here:
	 * 
	 * https://www.baeldung.com/spring-data-partial-update
	 */

}
