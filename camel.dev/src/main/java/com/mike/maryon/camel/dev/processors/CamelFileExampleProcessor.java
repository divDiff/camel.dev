package com.mike.maryon.camel.dev.processors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;

public class CamelFileExampleProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		System.out.println("Exchange in Processor is : " + exchange.getIn().getBody());
		GenericFile<File> file = (GenericFile<File>) exchange.getIn().getBody();
		
		String readLine = null;
		String newValue = "";
		if (file != null) {
			FileReader fr = new FileReader(file.getFile());
			BufferedReader br = new BufferedReader(fr);
			while ((readLine = br.readLine()) != null) {
				System.out.println("Read line is : " + readLine);
				String oldValue = readLine;
				newValue = newValue.concat(oldValue.replace(",", ":")).concat("\n");
				exchange.getIn().setBody(newValue);
			}
		}
	}
}
