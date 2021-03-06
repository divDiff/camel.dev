package com.mike.maryon.camel.dev.routes.process;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.Test;

import com.mike.maryon.camel.dev.util.AbstractCamelTest;

public class CamelModifyDirectProcessorRouteTest extends AbstractCamelTest {
	
	
	@Override
	public RoutesBuilder createRouteBuilder() {
		return new CamelModifyDirectProcessorRoute(); 
	}
	
	@Test
	public void processorDirectTest() {
		String expected = "123:mike:30MAR2019";
		String input = "123,mike,30MAR2019";
		
		String output = (String) template.requestBody("direct:processorInput", input);
		assertEquals(expected, output);
	}
	
	@Test
	public void processorDirectUsingMock() throws InterruptedException {
		String expected = "123:mike:30MAR2019";
		MockEndpoint mock = getMockEndpoint("mock:output");
		mock.expectedBodiesReceived(expected);
		
		String input = "123,mike,30MAR2019";
		
		template.sendBody("direct:processorInput", input);
		assertMockEndpointsSatisfied();
	}
}
