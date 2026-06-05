package com.inidivaragroup.jdt17.spring.dasar.example.service;

import org.springframework.stereotype.Component;

@Component
public class MerchantServiceImpl implements MerchantService {
    @Override
    public String getName() {
        return "Merchant Service";
    }
}
