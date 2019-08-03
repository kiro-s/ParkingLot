package com.gojek.parking.service;

import com.gojek.parking.model.Vehicle;

public interface ParkingServiceInterface {

	public void createParkingLot(int size) throws Exception;
	
	public Integer park(Vehicle vehicle) throws Exception;
	
	public void unPark(Integer slotNumber) throws Exception;
	
	public void getStatus() throws Exception;
	
	public void getRegNumbersForColor(String color) throws Exception;
	
	public void getSlotNumbersForColor(String color) throws Exception;
	
	public void getSlotNoFomRegistrationNumber(String registrationNo) throws Exception;
	
	public void doCleanup();
}
