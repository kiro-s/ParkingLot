package com.gojek.parking.constants;

public enum CommandsConstants {

	CREATE("create_parking_lot"),
    PARK("park"),
    LEAVE("leave"),
    STATUS("status"),
    REG_NUMBER_FOR_CARS_WITH_COLOUR("registration_numbers_for_cars_with_colour"),
    SLOT_NUMBERS_FOR_CARS_WITH_COLOUR("slot_numbers_for_cars_with_colour"),
    SLOT_NUMBER_FOR_REGISTRATION_NUMBER("slot_number_for_registration_number");
    
    private final String name;

	private CommandsConstants(String name) {
		this.name = name;
	}  
	
	public static CommandsConstants findByName(String command){
	    for(CommandsConstants str : values()){
	        if( str.toString().equals(command)){
	            return str;
	        }
	    }
	    return null;
	}
	

    public String toString() {
       return name;
    }
}
