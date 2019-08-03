package com.gojek.parking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.gojek.parking.model.LinearlyIncreasingSlot;
import com.gojek.parking.model.ParkingLot;
import com.gojek.parking.model.Slot;
import com.gojek.parking.model.Vehicle;

public class ParkingService implements ParkingServiceInterface{
	
	private ParkingLot parkingLot;
	

	public void createParkingLot(int size) {
		parkingLot=new ParkingLot(size);
		for(int i=0;i<size;i++) {
			parkingLot.getAvailableSlots().add(new LinearlyIncreasingSlot(i+1));
		}
		System.out.println("Created a parking lot with "+size+" slots");
	}

	public Integer park(Vehicle vehicle) {
		if(parkingLot.getAvailableSlots().isEmpty()) {
			//TODO
		}
		Slot slot=parkingLot.getAvailableSlots().poll();
		slot.setVehicle(vehicle);
		parkingLot.getFilledSlots().put(slot.getId(), slot);
		parkingLot.addSlotToColor(vehicle.getColor(), slot.getId());
		parkingLot.getRegNoSlotIdMap().put(vehicle.getRegistrationNo(), slot.getId());
		System.out.println("Allocated slot number: "+slot.getId());
		return slot.getId();
	}

	public void unPark(Integer slotNumber) {
		if(parkingLot.getFilledSlots().containsKey(slotNumber)) {
			Slot slot=parkingLot.getFilledSlots().get(slotNumber);
			parkingLot.removeSlotFromColor(slot.getVehicle().getColor(), slotNumber);
			parkingLot.getRegNoSlotIdMap().remove(slot.getVehicle().getRegistrationNo());
			slot.setVehicle(null);
			parkingLot.getAvailableSlots().add(slot);
			parkingLot.getFilledSlots().remove(slotNumber);
		}
		System.out.println("Slot number "+slotNumber+" is free");
	}

	public void getStatus() {
		//TODO
		System.out.println("Slot No. \t Registration No \t Colour");
		for (Integer slotNumber : parkingLot.getFilledSlots().keySet()) {
			Slot slot=parkingLot.getFilledSlots().get(slotNumber);
			System.out.println(slotNumber+" \t "+slot.getVehicle().getRegistrationNo()+" \t "+slot.getVehicle().getColor());
		}
		
	}

	public void getRegNumbersForColor(String color) {
		List<String> regNumbers=new ArrayList<String>();
		for (Integer slotNumber : parkingLot.getColorSlotIdMap().get(color)) {
			regNumbers.add(parkingLot.getFilledSlots().get(slotNumber).getVehicle().getRegistrationNo());
		}
		System.out.println(regNumbers.stream().collect(Collectors.joining(",")).toString());
	}

	public void getSlotNumbersForColor(String color) {
		Set<Integer> slots=parkingLot.getColorSlotIdMap().get(color);
		System.out.println(slots.stream().map(a -> String.valueOf(a)).collect(Collectors.joining(",")));
	}

	public void getSlotNoFomRegistrationNumber(String registrationNo) {
		if(parkingLot.getRegNoSlotIdMap().containsKey(registrationNo))
			System.out.println(parkingLot.getRegNoSlotIdMap().get(registrationNo));
		else
			//TODO
			System.out.println("Not Found");
		
				
	}

	public void doCleanup() {
		parkingLot=null;
	}

	

}
