package com.mike.maryon.camel.dev.routes.gson;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

import com.mike.maryon.camel.dev.domain.Employee;

public class MarshalUsingGsonRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		GsonDataFormat gdf = new GsonDataFormat(Employee.class);
		
		from("direct:marshalGson")
			.log("Marshaled Object is : ${body}")
			.marshal(gdf)
			.log("Marshaled Object is : ${body}");

	}

}
