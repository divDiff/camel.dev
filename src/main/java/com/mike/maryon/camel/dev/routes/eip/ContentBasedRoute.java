package com.mike.maryon.camel.dev.routes.eip;

import org.apache.camel.builder.RouteBuilder;

public class ContentBasedRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:data/input")
			.to("log:?level=INFO&showBody=true&showHeaders=true")
				.choice()
					.when(header("CamelFileNameConsumed").endsWith(".html"))
						.to("file:html")
					.when(header("CamelFileNameConsumed").endsWith(".json"))
						.to("file:json")
					.when(header("CamelFileNameConsumed").endsWith(".txt"))
						.to("file:text");
	}

}
