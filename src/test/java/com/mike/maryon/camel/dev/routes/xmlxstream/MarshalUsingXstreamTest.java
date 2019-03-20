package com.mike.maryon.camel.dev.routes.xmlxstream;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MarshalUsingXstreamTest extends CamelTestSupport {
	@Override
	public RoutesBuilder createRouteBuilder() {
		return new MarshalUsingXstream();
	}
	
	@Test
	public void marshalXstreamTest() throws InterruptedException {
		String input = "123,mike,30MAR2019";
		String expected = "<?xml version='1.0' encoding='UTF-8'?><com.mike.maryon.camel.dev.domain.Employee><id>123</id><name>mike</name><joinDate>30MAR2019</joinDate></com.mike.maryon.camel.dev.domain.Employee>";
		
		MockEndpoint mock = getMockEndpoint("mock:output");
		mock.expectedBodiesReceived(expected);
		template.sendBody("direct:csvNoAliasInput", input);
		assertMockEndpointsSatisfied();
		
	}
	
	@Test
	public void marshalXstreamTestEmployeeAlias() throws InterruptedException {
		String input = "123,mike,30MAR2019";
		String expected = "<?xml version='1.0' encoding='UTF-8'?><employee><id>123</id><name>mike</name><joinDate>30MAR2019</joinDate></employee>";
		
		MockEndpoint mock = getMockEndpoint("mock:output");
		mock.expectedBodiesReceived(expected);
		template.sendBody("direct:csvAliasInput", input);
		assertMockEndpointsSatisfied();
		
	}
}
