package com.gojek.parking.service;

import com.gojek.parking.model.Vehicle;

public interface ParkingServiceInterface {

	public void createParkingLot(int size);
	
	public Integer park(Vehicle vehicle);
	
	public void unPark(Integer slotNumber);
	
	public void getStatus();
	
	public void getRegNumbersForColor(String color);
	
	public void getSlotNumbersForColor(String color);
	
	public void getSlotNoFomRegistrationNumber(String registrationNo);
	
	public void doCleanup();
}
