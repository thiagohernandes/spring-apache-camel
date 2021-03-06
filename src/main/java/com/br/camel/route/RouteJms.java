package com.br.camel.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/*
 * Route de envio e recebimento de mensagens
 * OBS: realizar o download do server ActiveMQ (https://activemq.apache.org/components/classic/download/)
 * http://localhost:8161/ -> default user = "admin" e senha "admin"
 * @author Thiago Hernandes de Souza
 * @since 24-05-2019
 */

@Component
public class RouteJms extends RouteBuilder {

    public static final String filaMq = "activemq://everis-queue";

    @Autowired
    private ProducerTemplate producerTemplate;

    @Override
    public void configure() throws Exception {

        from("timer://everis?period=5000")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        String mensagem = UUID.randomUUID().toString();
                        log.info("**********************************");
                        log.info("Enviando.... '{}'", mensagem);
                        producerTemplate.sendBody(filaMq, mensagem);
                    }
                });

        from(filaMq)
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        String mensagem = exchange.getIn().getBody(String.class);
                        log.info("--------------------------------");
                        log.info("Mensagem recebida --> '{}' ", mensagem);
                    }
                });
    }
}