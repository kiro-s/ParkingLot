package com.gojek.parking.model;

public class LinearlyIncreasingSlot extends Slot{

	
	public LinearlyIncreasingSlot(int id) {
		super(id);
	}
	@Override
	public Integer getDistance() {
		return getId();
	}

	
}
