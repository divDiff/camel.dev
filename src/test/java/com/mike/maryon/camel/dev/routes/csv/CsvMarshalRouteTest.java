package com.mike.maryon.camel.dev.routes.csv;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.RoutesBuilder;
import org.junit.Test;

import com.mike.maryon.camel.dev.domain.CsvEmployee;
import com.mike.maryon.camel.dev.util.AbstractCamelTest;

public class CsvMarshalRouteTest extends AbstractCamelTest {

	@Override
	public RoutesBuilder createRouteBuilder() {
		// TODO Auto-generated method stub
		return new CsvMarshalRoute();
	}
	
	@Test
	public void marshalTest() {
		CsvEmployee emp = new CsvEmployee();
		emp.setId("1");
		emp.setFirstName("Mike");
		emp.setLastName("Smith");
		
		CsvEmployee emp1 = new CsvEmployee();
		emp1.setId("1");
		emp1.setFirstName("John");
		emp1.setLastName("Smith");
		List<CsvEmployee> emps = new ArrayList<>();
		emps.add(emp);
		emps.add(emp1);
		template.sendBody("direct:objectInput", emps);
		
		File file = new File("data/csv/output");
		assertTrue(file.isDirectory());
	}
}
