package com.br.camel.configuration;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ThreadPoolRejectedPolicy;
import org.apache.camel.spi.ThreadPoolProfile;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.ConnectionFactory;

import static org.apache.camel.component.jms.JmsComponent.jmsComponentAutoAcknowledge;

@Configuration
public class JmsConfiguration {

    public static final String DEFAULT_PROFILE = "profileDefaultJms";
    public static final String ACTIVEMQ = "activemq";


    @Bean
    CamelContextConfiguration contextConfiguration(@Value("${activemq.user}") String user,
                                                   @Value("${activemq.password}") String password,
                                                   @Value("${activemq.url}") String url) {
        return new CamelContextConfiguration() {
            @Override
            public void beforeApplicationStart(CamelContext context) {
                ThreadPoolProfile threadPoolProfile = new ThreadPoolProfile();
                threadPoolProfile.setId(DEFAULT_PROFILE);
                threadPoolProfile.setPoolSize(10);
                threadPoolProfile.setMaxPoolSize(15);
                threadPoolProfile.setMaxQueueSize(250);
                threadPoolProfile.setKeepAliveTime(25L);
                threadPoolProfile.setRejectedPolicy(ThreadPoolRejectedPolicy.Abort);
                context.getExecutorServiceManager().registerThreadPoolProfile(threadPoolProfile);
                ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
                context.addComponent(ACTIVEMQ, jmsComponentAutoAcknowledge(connectionFactory));
            }
            @Override
            public void afterApplicationStart(CamelContext camelContext) {
            }
        };
    }

}
