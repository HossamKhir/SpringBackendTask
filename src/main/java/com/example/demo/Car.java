package com.example.demo;

import java.awt.Color;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author khair
 *
 */
@Entity
@Component
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	private Color colour;
	private String model;
	/**
	 * fixed through:
	 * https://stackoverflow.com/questions/3774198/org-hibernate-mappingexception-could-not-determine-type-for-java-util-list-at
	 */
//	@OneToOne(targetEntity = Person.class)
//	private Person owner;
	// FIXME
	private String owner;
	@JsonIgnore
	private boolean hideMe;

	/**
	 * 
	 */
	protected Car() {
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
	public Car(String name, Color colour, String model, String owner, boolean hideMe) {
		super();
		this.name = name;
		this.colour = colour;
		this.model = model;
		this.owner = owner;
		this.hideMe = hideMe;
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return
	 */
	public Color getColour() {
		return colour;
	}

	/**
	 * 
	 * @return
	 */
	public String getModel() {
		return model;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isHideMe() {
		return hideMe;
	}

	/**
	 * 
	 * @return
	 */
	public long getId() {
		return id;
	}

	/**
	 * 
	 * @return
	 */
	public String getOwner() {
		return owner;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", colour=" + colour + ", model=" + model + ", owner=" + owner
				+ "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setColour(Color colour) {
		this.colour = colour;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setHideMe(boolean hideMe) {
		this.hideMe = hideMe;
	}

}
