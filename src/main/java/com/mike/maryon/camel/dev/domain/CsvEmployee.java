package com.mike.maryon.camel.dev.domain;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator= ",", skipFirstLine = true)

public class CsvEmployee { 
	
	@DataField(pos = 1)
	private String id;
	@DataField(pos = 2)
	private String firstName;
	@DataField(pos = 3)
	private String lastName;
	
	@Override
	public String toString() {
		return "Employee{id="+id +" firstname=" + firstName + " lastName=" + lastName + "}"; 
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
  