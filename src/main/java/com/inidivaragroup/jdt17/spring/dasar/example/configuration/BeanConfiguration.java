package com.inidivaragroup.jdt17.spring.dasar.example.configuration;

import com.inidivaragroup.jdt17.spring.dasar.example.dto.HelloDTO;
import com.inidivaragroup.jdt17.spring.dasar.example.dto.WorldDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    HelloDTO foo() {
        return new HelloDTO();
    }

    @Bean
    public WorldDTO world() {
        return new WorldDTO();
    }
}
