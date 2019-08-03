package com.gojek.parking.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class ParkingLot {

	private int size=0;
	private PriorityQueue<Slot> availableSlots;
	private Map<Integer,Slot> filledSlots;
	private Map<String,Set<Integer>> colorSlotIdMap;
	private Map<String,Integer> regNoSlotIdMap;
	
	
	public ParkingLot(int size) {
		super();
		this.size = size;
		this.filledSlots=new HashMap<Integer, Slot>();
		this.colorSlotIdMap=new HashMap<String, Set<Integer>>();
		this.regNoSlotIdMap=new HashMap<String, Integer>();
		this.availableSlots=new PriorityQueue<Slot>();
	}
	
	

	public Integer getSize() {
		return this.size;
	}
	public PriorityQueue<Slot> getAvailableSlots() {
		return availableSlots;
	}


	public void setAvailableSlots(PriorityQueue<Slot> availableSlots) {
		this.availableSlots = availableSlots;
	}


	public Map<Integer, Slot> getFilledSlots() {
		return filledSlots;
	}


	public void setFilledSlots(Map<Integer, Slot> filledSlots) {
		this.filledSlots = filledSlots;
	}


	

	public Map<String, Set<Integer>> getColorSlotIdMap() {
		return colorSlotIdMap;
	}



	public void setColorSlotIdMap(Map<String, Set<Integer>> colorSlotIdMap) {
		this.colorSlotIdMap = colorSlotIdMap;
	}
	public void addSlotToColor(String color,Integer slotNumber) {
		if(!colorSlotIdMap.containsKey(color)) {
			colorSlotIdMap.put(color, new HashSet<Integer>());
		}
		colorSlotIdMap.get(color).add(slotNumber);
	}
	public void removeSlotFromColor(String color,Integer slotNumber) {
		if(colorSlotIdMap.containsKey(color) && colorSlotIdMap.get(color).contains(slotNumber)) {
			colorSlotIdMap.get(color).remove(slotNumber);
			if(colorSlotIdMap.get(color).isEmpty())
				colorSlotIdMap.remove(color);
		}
	}


	public void setSize(int size) {
		this.size = size;
	}



	public Map<String, Integer> getRegNoSlotIdMap() {
		return regNoSlotIdMap;
	}


	public void setRegNoSlotIdMap(Map<String, Integer> regNoSlotIdMap) {
		this.regNoSlotIdMap = regNoSlotIdMap;
	}
	
	
	
	

}
