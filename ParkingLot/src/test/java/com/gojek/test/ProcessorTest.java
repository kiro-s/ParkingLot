package com.gojek.test;

import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import com.gojek.parking.processor.CommandLineProcessor;
import com.gojek.parking.processor.Processor;

public class ProcessorTest {

	static Processor processor = null;

	@BeforeClass
	public static void setUp() throws Exception {
		processor = new CommandLineProcessor();
		processor.ExecuteInstruction("create_parking_lot 6");
	}

	@Test
	public void testCreateProcess() {
		try {
			String str="create_parking_lot 6";
			processor.validateCommandsInput(str);
			processor.ExecuteInstruction(str);
		} catch (Exception e) {
			fail("createParkingLot method failed");
		}
	}
	
	@Test
	public void testPark() {
		try {
			String str="park Mh14-111 White";
			processor.validateCommandsInput(str);
			processor.ExecuteInstruction(str);
		} catch (Exception e) {
			fail("park method failed");
		}
	}

	@Test
	public void testPrintStatus() {
		try {
			String str="status";
			processor.validateCommandsInput(str);
			processor.ExecuteInstruction(str);
		} catch (Exception e) {
			fail("printStatus method failed");
		}
	}

	@Test
	public void testPrintSlotNumbersForColor() {
		try {
			String str="slot_numbers_for_cars_with_colour White";
			processor.validateCommandsInput(str);
			processor.ExecuteInstruction(str);
		} catch (Exception e) {
			fail("printSlotNumbersForColor method failed");
		}
	}

	@Test
	public void testPrintRegistrationNumbersForColor() {
		try {
			String str="registration_numbers_for_cars_with_colour White";
			processor.validateCommandsInput(str);
			processor.ExecuteInstruction(str);
		} catch (Exception e) {
			fail("printRegistrationNumbersForColor method failed");
		}
	}

	@Test
	public void testPrintSlotNoFomRegistrationNumber() {
		try {
			String str="slot_number_for_registration_number KA-01-HH-3141";
			processor.validateCommandsInput(str);
			processor.ExecuteInstruction(str);
		} catch (Exception e) {
			fail("printSlotNoFomRegistrationNumber method failed");
		}
	}


}
