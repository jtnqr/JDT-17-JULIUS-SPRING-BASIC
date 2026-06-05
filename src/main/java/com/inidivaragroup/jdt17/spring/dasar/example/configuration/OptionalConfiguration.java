package com.inidivaragroup.jdt17.spring.dasar.example.configuration;

import com.inidivaragroup.jdt17.spring.dasar.example.model.Bar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OptionalConfiguration {
    @Bean
    public Bar bar() {
        return new Bar();
    }
}
