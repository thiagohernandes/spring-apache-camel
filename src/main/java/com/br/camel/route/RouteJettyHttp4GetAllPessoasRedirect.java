package com.br.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.br.camel.constants.UtilConstants;

/*
 * Chamada inicial de URL para redirecionamento com Jetty
 * Fluxo: RouteJettyHttp4GetAllPessoasRedirect -> RouteJettyHttp4GetAllPessoas
 * @author Thiago Hernandes de Souza
 * @since 23-05-2019
 */

@Configuration 
class RouteJettyHttp4GetAllPessoasRedirect extends RouteBuilder{

	@Autowired
	private UtilConstants util;
	
	public void configure() throws Exception {
	    from("jetty:http://localhost:8082/hello")
	      .routeId(util.route3)
	      .to(util.directJettyPessoas);
	}
}
