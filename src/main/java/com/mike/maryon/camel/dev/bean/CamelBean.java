package com.mike.maryon.camel.dev.bean;

public class CamelBean {
	public String  map(String input) {
		String newBody = input.replace(",", "*");
		return newBody;
	}
	public String  map1(String input) {
		System.out.println("Inside Map1");
		String newBody = input.replace(",", "*");
		return newBody;
	}
}
