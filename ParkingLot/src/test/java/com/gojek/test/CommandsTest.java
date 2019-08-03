package com.gojek.test;

import static org.junit.Assert.assertTrue;

import com.gojek.parking.constants.CommandsConstants;

public class CommandsTest {
	 
	public void testCommandNegative() throws Exception {
	    	CommandsConstants command = CommandsConstants.findByName("create_parking_lot----null");
	    	assertTrue(command == null);
	    }
	    
	   
	public void testCommandPositive() throws Exception {
			CommandsConstants command = CommandsConstants.findByName("create_parking_lot");
	    	assertTrue(command != null);
	    }

}
