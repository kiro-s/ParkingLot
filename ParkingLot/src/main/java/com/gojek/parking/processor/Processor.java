package com.gojek.parking.processor;

import com.gojek.parking.constants.CommandsConstants;

public abstract class Processor {

	public void ExecuteInstruction(String inputStr) throws Exception {
		String[] input = inputStr.split(" ");
		
		CommandsConstants command = CommandsConstants.findByName(input[0]);
		
		if(command == null) {
			System.out.println("Invalid command");
			return;
		}
		
		switch(command) {
		case CREATE:
			// Initialize Parking Lot
			//TODO
			break;
		case PARK:
			// park a car in a nearest slot
			//TODO
			break;
		case LEAVE:
			// vacating a slot
			//TODO
			break;
		case STATUS:
			// Show all parked cars
			//TODO
			break;
		case REG_NUMBER_FOR_CARS_WITH_COLOUR:
			//TODO
			break;
		case SLOT_NUMBERS_FOR_CARS_WITH_COLOUR:
			//TODO
			break;
		case SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
			//TODO
			break;
		}
	}
	public abstract void process() throws Exception;

}
