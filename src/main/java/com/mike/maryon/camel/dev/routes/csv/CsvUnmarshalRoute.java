package com.mike.maryon.camel.dev.routes.csv;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

import com.mike.maryon.camel.dev.domain.CsvEmployee;

public class CsvUnmarshalRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		DataFormat bindy = new BindyCsvDataFormat(CsvEmployee.class);
		
		from("file:data/csv/input?fileName=test.csv&noop=true")
			.unmarshal(bindy)
			.log("Unmarshal message is ${body}")
			.to("direct:output");
	}

}
