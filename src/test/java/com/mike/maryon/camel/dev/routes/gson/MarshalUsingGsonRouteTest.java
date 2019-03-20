package com.mike.maryon.camel.dev.routes.gson;

import org.apache.camel.RoutesBuilder;
import org.junit.Test;

import com.mike.maryon.camel.dev.domain.Employee;
import com.mike.maryon.camel.dev.util.AbstractCamelTest;

public class MarshalUsingGsonRouteTest extends AbstractCamelTest {

	@Override
	public RoutesBuilder createRouteBuilder() {
		// TODO Auto-generated method stub
		return new MarshalUsingGsonRoute();
	}
	
	@Test
	public void marshalUsingGsonTest() {
		Employee emp = new Employee();
		emp.setId("1");
		emp.setName("mike");
		emp.setJoinDate("30Mar2019");
		String empJson = template.requestBody("direct:marshalGson", emp, String.class);
		String expected = "{\"id\":\"1\",\"name\":\"mike\",\"joinDate\":\"30Mar2019\"}";		
		assertEquals(expected, empJson);
	}
}
