package com.gojek.test.parking.constants;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gojek.parking.constants.CommandsConstants;

public class CommandsTest {
	 
	@Test
	public void testCommandNegative() throws Exception {
	    	CommandsConstants command = CommandsConstants.findByName("create_parking_lot----null");
	    	assertTrue(command == null);
	    }
	    
	@Test  
	public void testCommandPositive() throws Exception {
			CommandsConstants command = CommandsConstants.findByName("create_parking_lot");
	    	assertTrue(command != null);
	    }

}
