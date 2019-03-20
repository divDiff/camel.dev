package com.mike.maryon.camel.dev.routes.gson;

import org.apache.camel.RoutesBuilder;
import org.junit.Test;

import com.mike.maryon.camel.dev.domain.Employee;
import com.mike.maryon.camel.dev.util.AbstractCamelTest;

public class UnmarshalUsingGsonRouteTest extends AbstractCamelTest {

	@Override
	public RoutesBuilder createRouteBuilder() {
		// TODO Auto-generated method stub
		return new UnmarshalUsingGsonRoute();
	}
	
	@Test
	public void unmarshalUsingGson() {
		String input = "{\"id\":\"1\",\"name\":\"mike\",\"joinDate\":\"30Mar2019\"}";
		
		
		Employee emp = (Employee) template.requestBody("direct:unmarshalGson", input);
		assertEquals("1", emp.getId());
	}
}
