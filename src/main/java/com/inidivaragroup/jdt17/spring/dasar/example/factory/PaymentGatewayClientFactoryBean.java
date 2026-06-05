package com.inidivaragroup.jdt17.spring.dasar.example.factory;

import org.springframework.beans.factory.FactoryBean;

public class PaymentGatewayClientFactoryBean implements FactoryBean<PaymentGatewayClient> {
    @Override
    public PaymentGatewayClient getObject() throws Exception {
        return new PaymentGatewayClient("api-key", "secret-key");
    }

    @Override
    public Class<?> getObjectType() {
        return PaymentGatewayClient.class;
    }
}
