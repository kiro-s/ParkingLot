package com.gojek.parking.factory;

import com.gojek.parking.service.ParkingService;
import com.gojek.parking.service.ParkingServiceInterface;

public class ParkingFactory {

	
	public static ParkingServiceInterface getParkingService() {
		return new ParkingService();
	}

}
