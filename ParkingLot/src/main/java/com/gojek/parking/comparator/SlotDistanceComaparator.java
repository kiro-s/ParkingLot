package com.gojek.parking.comparator;

import java.util.Comparator;

import com.gojek.parking.model.Slot;

public class SlotDistanceComaparator implements Comparator<Slot>{

	@Override
	public int compare(Slot s1, Slot s2) {
		 if (s1.getDistance() > s2.getDistance()) 
             return 1; 
         else if (s1.getDistance() < s2.getDistance()) 
             return -1; 
         return 0; 
	}

	

}
