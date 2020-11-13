package com.example.demo;

import java.awt.Color;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
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

	/**
	 * 
	 * @param name
	 * @param owner
	 * @return
	 */
	List<Car> findByNameAndOwner(String name, String owner);

	/**
	 * 
	 * @param id
	 * @param sort
	 * @return
	 */
	List<Car> findById(long id, Sort sort);

	/**
	 * 
	 * @param name
	 * @param sort
	 * @return
	 */
	List<Car> findByName(String name, Sort sort);

	/**
	 * 
	 * @param colour
	 * @param sort
	 * @return
	 */
	List<Car> findByColour(Color colour, Sort sort);

	/**
	 * 
	 * @param model
	 * @param sort
	 * @return
	 */
	List<Car> findByModel(String model, Sort sort);

	/**
	 * 
	 * @param owner
	 * @param sort
	 * @return
	 */
	List<Car> findByOwner(String owner, Sort sort);

//	List<Car> findByHideMe(boolean hideMe, Sort sort);

}
