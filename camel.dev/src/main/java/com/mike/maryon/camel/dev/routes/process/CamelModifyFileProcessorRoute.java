package com.mike.maryon.camel.dev.routes.process;

import org.apache.camel.builder.RouteBuilder;

import com.mike.maryon.camel.dev.processors.CamelFileExampleProcessor;

public class CamelModifyFileProcessorRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:data/input?noop=true")
			.log("Read file is ${body} and headers are ${headers}")
			.process(new CamelFileExampleProcessor())
			.to("file:data/output?fileName=output.txt")
		.to("mock:output");
	}

}
