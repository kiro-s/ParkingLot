package com.gojek.parking.processor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandLineProcessor extends Processor{

	public void process() throws Exception {
		BufferedReader bufferReader=null;
		try {
		bufferReader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
        	String line = bufferReader.readLine();
        	validateCommandsInput(line);
        	ExecuteInstruction(line);
        }
		}
        finally {
        	if(bufferReader!=null)
        		bufferReader.close();
        }
	}

}
