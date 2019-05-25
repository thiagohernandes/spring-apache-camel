package com.br.camel.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.br.camel.constants.UtilConstants;

/*
 * Instância de uma URL com jetty
 * @author Thiago Hernandes de Souza
 * @since 23-05-2019
 */

@Configuration
public class RouteJetty extends RouteBuilder{

	@Autowired
	private UtilConstants util;
	
	public void configure() throws Exception {
	    from(util.routeHttpJetty8080)
	    	.routeId(util.route1)
	    	.transform().simple("Mensagem by Camel!!!")
			.process(new Processor() {
				@Override
				public void process(Exchange exchange) throws Exception {
					exchange.getIn().getBody(String.class);
					exchange.getOut().setBody(exchange.getIn().getBody(String.class));
				}
			})
		.toD(util.filaMq);
	}
}
