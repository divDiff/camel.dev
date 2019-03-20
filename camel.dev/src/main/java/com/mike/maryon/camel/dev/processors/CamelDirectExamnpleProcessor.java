package com.mike.maryon.camel.dev.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CamelDirectExamnpleProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		try {
			String oldValue = (String) exchange.getIn().getBody();
			String newValue = oldValue.replace(",", ":");
			exchange.getIn().setBody(newValue);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
