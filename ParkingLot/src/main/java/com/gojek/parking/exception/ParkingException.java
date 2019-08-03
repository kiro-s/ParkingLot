package com.gojek.parking.exception;

import com.gojek.parking.constants.ExceptionCode;

public class ParkingException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7869739526840161969L;
	
	private String message;
	private ExceptionCode code;
	public ParkingException(String message, ExceptionCode code) {
		super();
		this.message = message;
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public ExceptionCode getCode() {
		return code;
	}
	
	
	

}
