package com.mike.maryon.camel.dev.bean;

public class CamelBean {
	public String  map(String input) {
		String newBody = input.replace(",", "*");
		return newBody;
	}
}
