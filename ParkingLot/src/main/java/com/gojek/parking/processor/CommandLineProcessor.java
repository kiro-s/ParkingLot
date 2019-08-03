package com.gojek.parking.processor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandLineProcessor extends Processor{

	public void process() throws Exception {
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        
        
        while(true) {
        	String inputString = bufferRead.readLine();
        	ExecuteInstruction(inputString);
        }
	}

}
