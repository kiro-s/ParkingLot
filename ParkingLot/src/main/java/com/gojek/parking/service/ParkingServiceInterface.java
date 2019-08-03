package com.gojek.parking.service;

import com.gojek.parking.model.Vehicle;

public interface ParkingServiceInterface {

	public void createParkingLot(int size) throws Exception;
	
	public void park(Vehicle vehicle) throws Exception;
	
	public void unPark(Integer slotNumber) throws Exception;
	
	public void printStatus() throws Exception;
	
	public void printRegistrationNumbersForColor(String color) throws Exception;
	
	public void printSlotNumbersForColor(String color) throws Exception;
	
	public void printSlotNoFomRegistrationNumber(String registrationNo) throws Exception;
	
	public void doCleanup();
}
