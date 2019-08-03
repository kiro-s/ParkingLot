package com.gojek.parking.constants;

public enum ExceptionCode {

		ERROR_501(501),
		ERROR_502(502);
	
	private final Integer code;

	private ExceptionCode(Integer code) {
			this.code = code;
	}  

}
