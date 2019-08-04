package com.gojek.parking.constants;

public enum ExceptionCode {
		//critical errors need to print message
		ERROR_501(501),
		//warnings only
		ERROR_502(502);
	
	private final Integer code;

	private ExceptionCode(Integer code) {
			this.code = code;
	}  

}
