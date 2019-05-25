package com.br.camel.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.br.camel.constants.UtilConstants;

/*
 * Bridge entre duas URLs - utilizando Jetty - Observar a  Classe: RouteJettyHttp4GetAllPessoasRedirect
 * Fluxo: RouteJettyHttp4GetAllPessoasRedirect -> RouteJettyHttp4GetAllPessoas
 * @author Thiago Hernandes de Souza
 * @since 23-05-2019
 */

@Configuration
public class RouteJettyHttp4GetAllPessoas extends RouteBuilder{

	@Autowired
	private UtilConstants util;
	
	public void configure() throws Exception {
		from(util.directJettyPessoas)
		  .routeId(util.route2)
		  .setHeader(Exchange.HTTP_METHOD, constant(org.apache.camel.component.http4.HttpMethods.GET))
		  .to(util.bridgePessoas)
		  .log("${body}");
		
	}
	
	
}
