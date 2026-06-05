package com.inidivaragroup.jdt17.spring.dasar.example.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryBeanConfiguration {
    @Bean
    public PaymentGatewayClientFactoryBean paymentGatewayClient() {
        return new PaymentGatewayClientFactoryBean();
    }
}
