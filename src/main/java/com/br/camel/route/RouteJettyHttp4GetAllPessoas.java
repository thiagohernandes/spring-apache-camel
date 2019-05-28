package com.br.camel.route;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import com.br.camel.constants.UtilConstants;
import com.br.camel.domain.Pessoa;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
	
	JacksonDataFormat format = new ListJacksonDataFormat(Pessoa.class);
			
	public void configure() throws Exception {
		from(util.directJettyPessoas)
		  .routeId(util.route2)
		  .setHeader(Exchange.HTTP_METHOD, constant(org.apache.camel.component.http4.HttpMethods.GET))
		  .to(util.bridgePessoas)
		  .unmarshal(format)
		  .process(new Processor() {
				@Override
				public void process(Exchange exchange) throws Exception {
					log.info("IN ----> '{}'", formatListPessoa((List<Pessoa>) exchange.getIn().getBody()));
					log.info("IN 2 ----> '{}'", formatJson((List<Pessoa>) exchange.getIn().getBody()));
					log.info("OUT ----> '{}'", exchange.getOut().getBody());
				}
			})
		  .log("${body}");
		
		from(util.directJettyPessoasXML)
		  .routeId(util.route7)
		  .setHeader(Exchange.HTTP_METHOD, constant(org.apache.camel.component.http4.HttpMethods.GET))
		  .to(util.bridgePessoas)
		  .process(new Processor() {
				@Override
				public void process(Exchange exchange) throws Exception {
					log.info("XML ---------> '{}'",exchange.getIn().getBody());
				}
			})
		  .log("${body}");
	}
	
	private String formatListPessoa(List<Pessoa> lista) {
		StringBuilder strBuilder = new StringBuilder();
		lista.stream().forEach(item -> {
			strBuilder.append(item.getNome() + "\n");
		});
		return strBuilder.toString();
	}
	
	private String formatJson(List<?> lista) {
		GsonBuilder builder = new GsonBuilder();
	    Gson gson = builder.create();
	    return gson.toJson(lista);
	}
	
}
