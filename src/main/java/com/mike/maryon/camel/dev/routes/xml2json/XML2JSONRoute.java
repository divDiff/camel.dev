package com.mike.maryon.camel.dev.routes.xml2json;

import org.apache.camel.builder.RouteBuilder;

public class XML2JSONRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("direct:marshalEmployeexml2json")
			.to("log:?level=INFO&showBody=true")
			.marshal().xmljson()
			.to("log:?level=INFO&showBody=true");

	}

}
