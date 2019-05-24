package com.br.camel.bean;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.br.camel.util.UtilCamelContext;

@Configuration
public class JmsActiveMqBean extends RouteBuilder {
	
	@Autowired
	UtilCamelContext util;
	
	@Override
    public void configure() throws Exception {
		CamelContext context = new DefaultCamelContext();
	    context.addRoutes(new RouteBuilder() {
	        public void configure() {
	        	from("activemq:foo")
	            .to("log:sample");

	        	from("timer:bar")
	            .setBody(constant("Hello from Camel"))
	            .to("activemq:foo");
	        }
	    });
	    util.startStop(context, 2000);
        
    }

}
