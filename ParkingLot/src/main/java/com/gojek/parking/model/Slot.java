package com.gojek.parking.model;

public abstract class Slot {

	private int id;
	private Vehicle vehicle;
	
	
	

	public Vehicle getVehicle() {
		return vehicle;
	}


	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}


	public Slot(int id) {
		super();
		this.id = id;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public abstract Integer getDistance();
	
	public int compareTo(Slot o) {
		// TODO Auto-generated method stub
		return o.getDistance()-o.getDistance();
	}
}
