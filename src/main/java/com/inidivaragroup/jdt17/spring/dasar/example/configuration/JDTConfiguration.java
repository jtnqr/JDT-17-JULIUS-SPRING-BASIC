package com.inidivaragroup.jdt17.spring.dasar.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JDTConfiguration {
    @Bean
    public String getInitialConfiguration() {
        return "JDT-17 CONFIGURATION";
    }
}
