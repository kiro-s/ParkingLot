package com.gojek.parking.main;

import com.gojek.parking.processor.CommandLineProcessor;
import com.gojek.parking.processor.FileProcessor;
import com.gojek.parking.processor.Processor;

public class MainClass {

	public static void main(String[] args) throws Exception {
		
		Processor processor = null;
		
		if(args.length >= 1) {
			processor = new FileProcessor(args[0]);
		} else {
			processor = new CommandLineProcessor();
		}
		processor.process();
	}

}
