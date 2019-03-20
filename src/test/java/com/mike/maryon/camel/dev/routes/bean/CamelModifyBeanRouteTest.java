package com.mike.maryon.camel.dev.routes.bean;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyBeanRouteTest extends CamelTestSupport {
	@Override
	public RoutesBuilder createRouteBuilder() {
		return new CamelModifyBeanRoute();
	}
	
	@Test
	public void beanTest() {
		String expected = "123*mike*30MAR2019";
		String input = "123,mike,30MAR2019";
		
		String actual = (String) template.requestBody("direct:beanInput", input);
		assertEquals(expected, actual);
	}
}
