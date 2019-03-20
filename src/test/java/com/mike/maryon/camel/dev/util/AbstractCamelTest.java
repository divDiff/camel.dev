package com.mike.maryon.camel.dev.util;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;

public abstract class AbstractCamelTest extends CamelTestSupport {
	@Override
	public abstract RoutesBuilder createRouteBuilder();
}
