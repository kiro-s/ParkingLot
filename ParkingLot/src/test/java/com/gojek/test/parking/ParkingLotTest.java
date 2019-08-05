package com.gojek.test.parking;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.gojek.parking.model.ParkingLot;
import com.gojek.parking.model.Slot;
import com.gojek.parking.service.SlotInitializer;

public class ParkingLotTest {

	static ParkingLot parkingLot;
	
	@BeforeClass
	public static void setUp() throws Exception {
		parkingLot=new ParkingLot(2);
		SlotInitializer.initializeSlots(parkingLot);
	}
	
	@Test
	public void testIncreasingDistance() {
		
			Slot s1= parkingLot.getAvailableSlots().poll();
			Slot s2=parkingLot.getAvailableSlots().poll();
			assertTrue(s1.getDistance()<s2.getDistance());
	}
}
