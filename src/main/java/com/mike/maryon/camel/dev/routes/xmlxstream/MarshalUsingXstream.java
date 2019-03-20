package com.mike.maryon.camel.dev.routes.xmlxstream;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xstream.XStreamDataFormat;

import com.mike.maryon.camel.dev.domain.Employee;
import com.mike.maryon.camel.dev.routes.processors.CustomProcessorXstream;

public class MarshalUsingXstream extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from ("direct:csvNoAliasInput")
			.process(new CustomProcessorXstream())
			.marshal().xstream()
			.to("log:?level=INFO&showBody=true")
			.to("mock:output");
		
		from ("direct:csvAliasInput")
			.process(new CustomProcessorXstream())
			.marshal(populateStreamDef())
			.to("log:?level=INFO&showBody=true")
			.to("mock:output");
	}
	
	private XStreamDataFormat populateStreamDef() {
		XStreamDataFormat dataFormat = new XStreamDataFormat();
		Map<String,String> aliases = new HashMap<>();
		aliases.put("employee", Employee.class.getCanonicalName());
		dataFormat.setAliases(aliases);
		return dataFormat;
	}
}
