package com.mike.maryon.camel.dev.routes.csv;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

import com.mike.maryon.camel.dev.domain.CsvEmployee;

public class CsvMarshalRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		DataFormat bindy = new BindyCsvDataFormat(CsvEmployee.class);
		
		from("direct:objectInput")
			.log("Received message is ${body}")
			.marshal(bindy)
			.log("Received message is ${body}")
			.to("file:data/csv/output?fileName=output.txt");
			
	}

}
