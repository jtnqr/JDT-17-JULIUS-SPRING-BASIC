package com.inidivaragroup.jdt17.spring.dasar.example.configuration;

import com.inidivaragroup.jdt17.spring.dasar.example.dto.HelloDTO;
import com.inidivaragroup.jdt17.spring.dasar.example.dto.WorldDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class DependsOnConfiguration {

    @Bean
    @DependsOn(value = ("bar"))
    public HelloDTO foo() {
        System.out.println("-> Initializing HelloDTO (foo)");
        return new HelloDTO();
    }

    @Bean
    public WorldDTO bar() {
        System.out.println("-> Initializing WorldDTO (bar)");
        return new WorldDTO();
    }
}
