package com.br.camel.constants;

import org.springframework.stereotype.Component;

/*
 * Constantes da Aplicação
 * @author Thiago Hernandes de Souza
 * @since 23-05-2019
 */

@Component
public class UtilConstants {

	public final String directJettyPessoas = "direct:getpessoas";
	public final String directJettyJms = "direct:jms-fila";
	public final String routeHttpJetty8080 = "jetty:http://localhost:8080/hello";
	public final String routeHttpJetty8082 = "jetty:http://localhost:8082/hello";
	public final String bridgePessoas = "http4://localhost:8088/api/pessoas/all?bridgeEndpoint=true";
	public final String route1 = "route1";
	public final String route2 = "route2";
	public final String route3 = "route3";
	public final String filaMq = "activemq://everis-queue";
	public final String timerFila = "timer://everis?period=8000";

}
