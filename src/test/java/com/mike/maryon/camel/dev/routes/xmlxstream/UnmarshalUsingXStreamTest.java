package com.mike.maryon.camel.dev.routes.xmlxstream;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.Test;

import com.mike.maryon.camel.dev.domain.Employee;
import com.mike.maryon.camel.dev.util.AbstractCamelTest;

public class UnmarshalUsingXStreamTest extends AbstractCamelTest {
	
	@Override
	public RoutesBuilder createRouteBuilder() {
		return new UnmarshalUsingXStream();
	}
	
	@Test
	public void unmarshalXStreamTest() throws InterruptedException {
		Employee emp = new Employee();
		emp.setJoinDate("30MAR2019");
		emp.setName("mike");
		emp.setId("123");
		
		String xmlInput = "<employee><id>123</id><name>mike</name><joinDate>30MAR2019</joinDate></employee>";
		
		MockEndpoint mock = getMockEndpoint("mock:output");
		mock.expectedBodiesReceived(emp.toString());
		template.sendBody("direct:xmlInput", xmlInput);
		assertMockEndpointsSatisfied();
	}
}
