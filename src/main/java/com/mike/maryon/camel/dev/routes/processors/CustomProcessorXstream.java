package com.mike.maryon.camel.dev.routes.processors;

import java.util.StringTokenizer;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.mike.maryon.camel.dev.domain.Employee;

public class CustomProcessorXstream implements Processor {

	public void process(Exchange exchange) throws Exception {
		String newBody = exchange.getIn().getBody(String.class);
		StringTokenizer tokenizer = new StringTokenizer(newBody, ",");
		
		Employee emp = new Employee();
		while (tokenizer.hasMoreElements()) {
			emp.setId((String)tokenizer.nextElement());
			emp.setName((String)tokenizer.nextElement());
			emp.setJoinDate((String)tokenizer.nextElement());
		}
		
		exchange.getIn().setBody(emp);
	}

}
