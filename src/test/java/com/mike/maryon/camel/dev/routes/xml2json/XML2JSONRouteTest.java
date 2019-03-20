 package com.mike.maryon.camel.dev.routes.xml2json;

import org.apache.camel.RoutesBuilder;
import org.junit.Test;

import com.mike.maryon.camel.dev.util.AbstractCamelTest;

public class XML2JSONRouteTest extends AbstractCamelTest {

	@Override
	public RoutesBuilder createRouteBuilder() {
		// TODO Auto-generated method stub
		return new XML2JSONRoute();
	}
	
	@Test
	public void marshalEmployee2jsonxmlTest() {
		String input = "<?xml version='1.0' encoding='UTF-8'?><employee><id>123</id><name>mike</name><joinDate>30MAR2019</joinDate></employee>";
		String response = template.requestBody("direct:marshalEmployeexml2json", input, String.class);
		String expected = "{\"id\":\"123\",\"name\":\"mike\",\"joinDate\":\"30MAR2019\"}";
		assertEquals(expected, response);
	}
	
	@Test
	public void unmarshalEmployeejson2xml() {
		String input = "{\"id\":\"123\",\"name\":\"mike\",\"joinDate\":\"30MAR2019\"}";
		String expected = "<?xml version='1.0' encoding='UTF-8'?>\r\n<employee><id>123</id><name>mike</name><joinDate>30MAR2019</joinDate></employee>\r\n ";
		String response = template.requestBody("direct:unmarshalEmployeejson2xml", input, String.class);
		assertEquals(expected, response); 
	}
}
