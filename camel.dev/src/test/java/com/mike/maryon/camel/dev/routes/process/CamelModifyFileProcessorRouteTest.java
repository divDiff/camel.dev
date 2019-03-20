package com.mike.maryon.camel.dev.routes.process;

import java.io.File;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.mike.maryon.camel.dev.routes.process.CamelModifyFileProcessorRoute;

public class CamelModifyFileProcessorRouteTest extends CamelTestSupport {

	@Override
	public RouteBuilder createRouteBuilder() {
		return new CamelModifyFileProcessorRoute();
	}
	
	@Test
	public void processorTest() throws InterruptedException {
		
		String expected = "123:mike:30MAR2019\n" + 
				"23454:joe:30MAR2019\n";
		MockEndpoint mock = getMockEndpoint("mock:output");
		mock.expectedBodiesReceived(expected);
		Thread.sleep(5000);
		
		File file = new File("data/output");
		assertTrue(file.isDirectory());
		assertMockEndpointsSatisfied();
	}
}
