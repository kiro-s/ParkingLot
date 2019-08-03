package com.gojek.parking.processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileProcessor extends Processor{
	
	private String filePath = null;

	public FileProcessor(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public void process() throws Exception {
		File inputFile = new File(filePath);
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		String line;
		while ((line = br.readLine()) != null) {
			validateCommandsInput(line);
			ExecuteInstruction(line);
		}
	}

	

}
