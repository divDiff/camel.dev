package com.mike.maryon.camel.dev.routes.csv;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.junit.Test;

import com.mike.maryon.camel.dev.domain.CsvEmployee;
import com.mike.maryon.camel.dev.util.AbstractCamelTest;

public class CsvUnmarshalRouteTest extends AbstractCamelTest {

	@Override
	public RoutesBuilder createRouteBuilder() {
		// TODO Auto-generated method stub
		return new CsvUnmarshalRoute() ;
	}
	
	@Test
	public void csvUnmarshalRoute() throws InterruptedException {
		List<CsvEmployee> emps = new ArrayList<>();
		Exchange exch = consumer.receive("direct:output");
		Thread.sleep(5000);
		emps = (List<CsvEmployee>) exch.getIn().getBody();
		
		assertEquals("mike", emps.get(0).getFirstName());
		assertEquals("ellen", emps.get(1).getFirstName());
	}
}
