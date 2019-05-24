package com.br.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.br.camel.constants.UtilConstants;

/*
 * Estância de uma URL com jetty
 * @author Thiago Hernandes de Souza
 * @since 23-05-2019
 */

@Component
@Configuration
public class RouteJetty extends RouteBuilder{

	@Autowired
	private UtilConstants util;
	
	public void configure() throws Exception {
	    from("jetty:http://localhost:8080/hello")
	    	.routeId(util.route1)
	    	.transform().simple("Hello world Camel!!!");
	}
}
