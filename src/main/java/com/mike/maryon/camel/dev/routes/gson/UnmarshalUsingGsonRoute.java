package com.mike.maryon.camel.dev.routes.gson;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

import com.mike.maryon.camel.dev.domain.Employee;

public class UnmarshalUsingGsonRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		GsonDataFormat gdf = new GsonDataFormat(Employee.class);
		
		from("direct:unmarshalGson")
			.log("Unmarshaled Object is : ${body}")
			.unmarshal(gdf)
			.log("Unmarshaled Object is : ${body}");
	}

}
