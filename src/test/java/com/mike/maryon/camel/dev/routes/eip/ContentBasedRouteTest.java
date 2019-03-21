package com.mike.maryon.camel.dev.routes.eip;

import java.io.File;

import org.apache.camel.RoutesBuilder;
import org.junit.Test;

import com.mike.maryon.camel.dev.util.AbstractCamelTest;

public class ContentBasedRouteTest extends AbstractCamelTest {

	@Override
	public RoutesBuilder createRouteBuilder() {
		// TODO Auto-generated method stub
		return new ContentBasedRoute();
	}
	
	@Test
	public void contentBasedMoveTest() throws InterruptedException {
		
		Thread.sleep(5000);
		File file1 = new File("html");
		File file2 = new File("json");
		File file3 = new File("text");
		
		assertTrue(file1.isDirectory());
		assertTrue(file2.isDirectory());
		assertTrue(file3.isDirectory());
	}
}
