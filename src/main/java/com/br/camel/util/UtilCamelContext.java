package com.br.camel.util;

import org.apache.camel.CamelContext;
import org.springframework.stereotype.Component;

/*
 * Util - iniciar e parar contexto
 * @author Thiago Hernandes de Souza
 * @since 24-05-2019
 */

@Component
public class UtilCamelContext {
	
	public void startStop(CamelContext camelContext, int sleepMiliseg) {
		try {
			camelContext.start();
		    Thread.sleep(sleepMiliseg);
		    camelContext.stop();
		}catch(Exception e) {
			System.err.print("Erro no start do Camel Context -> " + e.getMessage());
		}
	}

}
