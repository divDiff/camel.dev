package com.mike.maryon.camel.dev.routes.xml2json;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;

public class XML2JSONRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		XmlJsonDataFormat dataFormat = new XmlJsonDataFormat();
		dataFormat.setRootName("employee");
		// TODO Auto-generated method stub
		from("direct:marshalEmployeexml2json")
			.to("log:?level=INFO&showBody=true")
			.marshal().xmljson()
			.to("log:?level=INFO&showBody=true");
		
		from("direct:unmarshalEmployeejson2xml")
			.to("log:?level=INFO&showBody=true")
			.unmarshal(dataFormat )
			.to("log:?level=INFO&showBody=true");

	}

}
