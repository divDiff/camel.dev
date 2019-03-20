package com.mike.maryon.camel.dev.routes.xmlxstream;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xstream.XStreamDataFormat;

import com.mike.maryon.camel.dev.domain.Employee;

public class UnmarshalUsingXStream extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		Map<String,String> aliases = new HashMap<>();
		aliases.put("employee", Employee.class.getName());
		XStreamDataFormat dataFormat = new XStreamDataFormat();
		dataFormat.setAliases(aliases);
		dataFormat.setPermissions(Employee.class.getName());
		
		from("direct:xmlInput")
			.unmarshal(dataFormat)
			.to("log:?level=INFO&showBody=true")
			.to("mock:output");

	}

}
