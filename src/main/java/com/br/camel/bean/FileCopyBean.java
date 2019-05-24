package com.br.camel.bean;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.br.camel.util.UtilCamelContext;

/*
 * Mover arquivos
 * @author Thiago Hernandes de Souza
 * @since 24-05-2019
 */

@Configuration
public class FileCopyBean extends RouteBuilder {
	
	@Autowired
	UtilCamelContext util;
	
	@Override
	public void configure() throws Exception {
		CamelContext context = new DefaultCamelContext();
	    context.addRoutes(new RouteBuilder() {
	        public void configure() {
	            from("file:C:/Dev/temp-files/folder-a?noop=true")
	    			.to("file:C:/Dev/temp-files/folder-b");
	    		from("file:folder-in?fileName=teste.txt")
	    			.to("file:folder-out?fileName=testeCopy.csv");
	        }
	    });
	    util.startStop(context, 2000);
	}
	
}
