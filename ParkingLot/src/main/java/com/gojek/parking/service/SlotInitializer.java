package com.gojek.parking.service;

import com.gojek.parking.model.LinearlyIncreasingSlot;
import com.gojek.parking.model.ParkingLot;

public class SlotInitializer {

	// configuration for different slots distance approach.
	static boolean isLinearlySlots=true;
	
	
	public static void initializeSlots(ParkingLot parkingLot) {
		if(isLinearlySlots) {
			int size=parkingLot.getSize();
			for(int i=0;i<size;i++) {
				parkingLot.getAvailableSlots().add(new LinearlyIncreasingSlot(i+1));
			}
		}
	}

}
