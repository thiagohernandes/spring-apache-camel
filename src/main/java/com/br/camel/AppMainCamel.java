package com.br.camel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

}
