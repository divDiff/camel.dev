package com.mike.maryon.camel.dev.routes.transform;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyTransformRouteTest extends CamelTestSupport {
	@Override
	public RoutesBuilder createRouteBuilder() {
		return new CamelModifyTransformRoute(); 
	}
	
	@Test
	public void transformTest() {
		String expected = "123*mike*30MAR2019";
		String input = "123,mike,30MAR2019";
		
		String actual = (String) template.requestBody("direct:transformInput", input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testTransformUsingMock() throws InterruptedException {
		String expected = "123*mike*30MAR2019";
		String input = "123,mike,30MAR2019";
		
		MockEndpoint mock = getMockEndpoint("mock:output");
		mock.expectedBodiesReceived(expected);
		template.sendBody("direct:transformInput", input);
		assertMockEndpointsSatisfied();
	}
	
}
