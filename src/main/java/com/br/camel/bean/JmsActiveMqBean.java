package com.br.camel.bean;

import com.br.camel.constants.UtilConstants;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.br.camel.util.UtilCamelContext;

@Configuration
public class JmsActiveMqBean extends RouteBuilder {
	
	@Autowired
	UtilCamelContext utilCamelContext;

	@Autowired
	UtilConstants utilConstants;
	
	@Override
    public void configure() throws Exception {
		CamelContext context = new DefaultCamelContext();
	    context.addRoutes(new RouteBuilder() {
	        public void configure() {
	        	from(utilConstants.timerStart)
	            .to(utilConstants.activeMqStart);

				from(utilConstants.activeMqStart)
				.to("log:sample");
	        }
	    });
		utilCamelContext.startStop(context, 2000);
        
    }

}
