package com.br.camel;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/*
 * Main Class App
 * @author Thiago Hernandes de Souza
 * @since 23-05-2019
 */

@SpringBootApplication
@ComponentScan(basePackages=("com.br.camel"))
public class AppMainCamel {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(AppMainCamel.class, args);
	}
	
//	@SuppressWarnings("rawtypes")
//	@Bean
//	ServletRegistrationBean servletRegistrationBean() {
//		@SuppressWarnings("unchecked")
//		final ServletRegistrationBean servlet = new ServletRegistrationBean(
//				new CamelHttpTransportServlet(), "/*");
//		servlet.setName("CamelServlet");
//		return servlet;
//	}

}
