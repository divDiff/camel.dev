package com.mike.maryon.camel.dev.routes.process;

import org.apache.camel.builder.RouteBuilder;

import com.mike.maryon.camel.dev.processors.CamelDirectExamnpleProcessor;

public class CamelModifyDirectProcessorRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:processorInput")
			.log("Received message before process is is ${body} and headers are ${headers}")
			.process(new CamelDirectExamnpleProcessor())
			.log("Received message after process is ${body} and headers are ${headers}")
			.to("file:data/output?fileName=output.txt")
		.to("mock:output");
		
	}

}
