package com.br.camel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.br.camel")
public class AppMainCamel {

	public static void main(String[] args) {
		SpringApplication.run(AppMainCamel.class, args);
	}

}
