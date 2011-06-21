package org.tacs.tp.objectifyObjects;

import javax.persistence.*;;

public class Car {
	public @Id Long id;
	String vin;
	String color;
	@Transient String doNotPersist;

	@SuppressWarnings("unused")
	private Car(){};
	
	public Car(String vin, String color) {
		this.vin = vin;
		this.color = color;
	}
	
	public String getColor(){
		return this.color;
	}
	public String getVin(){
		return this.vin;
	}
}
