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

	//Execute each command
	public void ExecuteInstruction(String inputStr) throws Exception {
		try{
		String[] input = inputStr.split(" ");
		
		CommandsConstants command = CommandsConstants.findByName(input[0]);
		
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
			parkingService.printStatus();
			break;
		case REG_NUMBER_FOR_CARS_WITH_COLOUR:
			parkingService.printRegistrationNumbersForColor(input[1]);
			break;
		case SLOT_NUMBERS_FOR_CARS_WITH_COLOUR:
			parkingService.printSlotNumbersForColor(input[1]);
			break;
		case SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
			parkingService.printSlotNoFomRegistrationNumber(input[1]);
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
	
	//Validate If Each Command has complete Arguments.
	public void validateCommandsInput(String inputStr) throws Exception{
		String[] inputStrArr = inputStr.split(" ");
		CommandsConstants command = CommandsConstants.findByName(inputStrArr[0]);
		if(command == null) {
			System.out.println("Invalid command");
			return;
		}
		
		try {
		switch(command) {
		case CREATE:
			if(inputStrArr.length != 2) {
				throw new Exception();
			} 
			break;
		case PARK:
			if(inputStrArr.length != 3) {
				throw new Exception();
			} 
			break;
		case LEAVE:
			if(inputStrArr.length != 2) {
				throw new Exception();
			} 
			break;
		case STATUS:
			if(inputStrArr.length != 1) {
				throw new Exception();
			}
			break;
		case REG_NUMBER_FOR_CARS_WITH_COLOUR:
			if(inputStrArr.length != 2) {
				throw new Exception();
			}
			break;
		case SLOT_NUMBERS_FOR_CARS_WITH_COLOUR:
			if(inputStrArr.length != 2) {
				throw new Exception();
			}
			break;
		case SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
			if(inputStrArr.length != 2) {
				throw new Exception();
			}
			break;
		case EXIT:
			if(inputStrArr.length != 1) {
				throw new Exception();
			}
			break;
		}
		}
		catch(Exception e) {
			throw new Exception("Invalid no of arguments for command : " + command);
		}
	}
	public abstract void process() throws Exception;

}
