package com.example.demo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	List<Person> findById(long id);

	List<Person> findByFirstName(String firstName);

	List<Person> findBySurname(String surname);

	List<Person> findByDateOfBirth(Date dateOfBirth);

}
