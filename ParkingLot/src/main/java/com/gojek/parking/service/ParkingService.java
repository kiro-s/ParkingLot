package com.gojek.parking.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.gojek.parking.constants.ExceptionCode;
import com.gojek.parking.exception.ParkingException;
import com.gojek.parking.model.ParkingLot;
import com.gojek.parking.model.Slot;
import com.gojek.parking.model.Vehicle;

public class ParkingService implements ParkingServiceInterface{
	
	private ParkingLot parkingLot;
	
	// initializing parking lot with all slots available
	public void createParkingLot(int size) throws Exception{
		if(parkingLot!=null)
			throw new ParkingException("ParkingLot is Already Created",ExceptionCode.ERROR_501);
		parkingLot=new ParkingLot(size);
		SlotInitializer.initializeSlots(parkingLot);
		System.out.println("Created a parking lot with "+size+" slots");
	}

	//park vehicle in nearest available slot
	public void park(Vehicle vehicle) throws Exception{
		if(parkingLot.getAvailableSlots().isEmpty()) {
			throw new ParkingException("Sorry, parking lot is full",ExceptionCode.ERROR_501);
		}
		Slot slot=parkingLot.getAvailableSlots().poll();
		slot.setVehicle(vehicle);
		parkingLot.getFilledSlots().put(slot.getId(), slot);
		parkingLot.addSlotToColor(vehicle.getColor(), slot.getId());
		parkingLot.getRegNoSlotIdMap().put(vehicle.getRegistrationNo(), slot.getId());
		System.out.println("Allocated slot number: "+slot.getId());
	}

	//remove vehicle from a slot
	public void unPark(Integer slotNumber) throws Exception{
		if(slotNumber>parkingLot.getSize())
			throw new ParkingException("Slot is out of parkingLotSize: "+slotNumber,ExceptionCode.ERROR_501);
		boolean isSlotFree=!parkingLot.getFilledSlots().containsKey(slotNumber);
		if(!isSlotFree) {
			Slot slot=parkingLot.getFilledSlots().get(slotNumber);
			parkingLot.removeSlotFromColor(slot.getVehicle().getColor(), slotNumber);
			parkingLot.getRegNoSlotIdMap().remove(slot.getVehicle().getRegistrationNo());
			slot.setVehicle(null);
			parkingLot.getAvailableSlots().add(slot);
			parkingLot.getFilledSlots().remove(slotNumber);
		}
		System.out.println("Slot number "+slotNumber+" is free");
		if(isSlotFree) {
			throw new ParkingException("Slot is Already Empty: "+slotNumber,ExceptionCode.ERROR_502);
		}
	}
	
	//print details of every parked vehicle
	public void printStatus() throws Exception{
		
		System.out.println("Slot No. \t Registration No \t Colour");
		List<Integer> slots= new ArrayList<Integer>(parkingLot.getFilledSlots().keySet());
		Collections.sort(slots);
		for (Integer slotNumber : slots) {
			Slot slot=parkingLot.getFilledSlots().get(slotNumber);
			System.out.println(slotNumber+" \t "+slot.getVehicle().getRegistrationNo()+" \t "+slot.getVehicle().getColor());
		}
		
		if(parkingLot.getFilledSlots().isEmpty())
			throw new ParkingException("Parking Lot is Empty",ExceptionCode.ERROR_502);
	}

	//print all vehicles of particular color
	public void printRegistrationNumbersForColor(String color) throws Exception{
		if(!parkingLot.getColorSlotIdMap().containsKey(color))
			throw new ParkingException("Parking Lot has no car of this Color",ExceptionCode.ERROR_501);
		
		List<String> regNumbers=new ArrayList<String>();
		List<Integer> slots=new ArrayList<Integer>(parkingLot.getColorSlotIdMap().get(color));
		Collections.sort(slots);
		for (Integer slotNumber : slots) {
			regNumbers.add(parkingLot.getFilledSlots().get(slotNumber).getVehicle().getRegistrationNo());
		}
		System.out.println(regNumbers.stream().collect(Collectors.joining(",")).toString());
	}

	//print all slot filled with a same colored vehicle
	public void printSlotNumbersForColor(String color) throws Exception{
		if(!parkingLot.getColorSlotIdMap().containsKey(color))
			throw new ParkingException("Parking Lot has no car of this Color",ExceptionCode.ERROR_501);
		
		List<Integer> slots=new ArrayList<Integer>(parkingLot.getColorSlotIdMap().get(color));
		Collections.sort(slots);
		System.out.println(slots.stream().map(a -> String.valueOf(a)).collect(Collectors.joining(",")));
	}

	// print slot number for a particular vehicle
	public void printSlotNoFomRegistrationNumber(String registrationNo) throws Exception{
		if(parkingLot.getRegNoSlotIdMap().containsKey(registrationNo))
			System.out.println(parkingLot.getRegNoSlotIdMap().get(registrationNo));
		else
			throw new ParkingException("Not found",ExceptionCode.ERROR_501);
			
		
				
	}

	// cleanup for garbage collection.
	public void doCleanup() {
		parkingLot=null;
	}

	

}
