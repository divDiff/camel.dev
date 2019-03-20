package com.mike.maryon.camel.dev.routes.bean;

import org.apache.camel.builder.RouteBuilder;

import com.mike.maryon.camel.dev.bean.CamelBean;

public class CamelModifyBeanRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:beanInput")
			.log("Changed Message before bean is : ${body}")
			.bean(new CamelBean(), "map1")
			.log("Changed Message after bean is : ${body}")
		.to("mock:output");
		

	}

}
