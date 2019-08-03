package com.gojek.parking.processor;

import com.gojek.parking.constants.CommandsConstants;
import com.gojek.parking.constants.ExceptionCode;
import com.gojek.parking.exception.ParkingException;
import com.gojek.parking.model.Car;
import com.gojek.parking.model.Vehicle;
import com.gojek.parking.service.ParkingService;
import com.gojek.parking.service.ParkingServiceInterface;

public abstract class Processor {
	
	private ParkingServiceInterface parkingService=new ParkingService();

	public void ExecuteInstruction(String inputStr) throws Exception {
		try{
		String[] input = inputStr.split(" ");
		
		CommandsConstants command = CommandsConstants.findByName(input[0]);
		
		if(command == null) {
			System.out.println("Invalid command");
			return;
		}
		
		switch(command) {
		case CREATE:
			int size = Integer.parseInt(input[1]);
			parkingService.createParkingLot(size);
			break;
		case PARK:
			String regNo = input[1];
			String color = input[2];
			Vehicle vehicle=new Car(regNo,color);
			parkingService.park(vehicle);
			break;
		case LEAVE:
			int slotNumber = Integer.parseInt(input[1]);
			parkingService.unPark(slotNumber);
			break;
		case STATUS:
			parkingService.getStatus();
			break;
		case REG_NUMBER_FOR_CARS_WITH_COLOUR:
			parkingService.getRegNumbersForColor(input[1]);
			break;
		case SLOT_NUMBERS_FOR_CARS_WITH_COLOUR:
			parkingService.getSlotNumbersForColor(input[1]);
			break;
		case SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
			parkingService.getSlotNoFomRegistrationNumber(input[1]);
			break;
		case EXIT:
			parkingService.doCleanup();
			System.exit(0);
			break;
		}
		}
		catch(ParkingException pe) {
			if(pe.getCode().equals(ExceptionCode.ERROR_501)) {
				System.out.println(pe.getMessage());
			}
		}
		catch(Exception e) {
			throw e;
		}
	}
	public abstract void process() throws Exception;

}
