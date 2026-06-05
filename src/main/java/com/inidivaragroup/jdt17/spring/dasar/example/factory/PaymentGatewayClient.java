package com.inidivaragroup.jdt17.spring.dasar.example.factory;

public class PaymentGatewayClient {
    private final String apiKey;
    private final String secretKey;

    public PaymentGatewayClient(String apiKey, String secretKey) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getSecretKey() {
        return secretKey;
    }
}
