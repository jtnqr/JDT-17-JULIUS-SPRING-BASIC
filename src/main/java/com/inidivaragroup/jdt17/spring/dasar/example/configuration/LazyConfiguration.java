package com.inidivaragroup.jdt17.spring.dasar.example.configuration;

import com.inidivaragroup.jdt17.spring.dasar.example.dto.HelloDTO;
import com.inidivaragroup.jdt17.spring.dasar.example.dto.WorldDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class LazyConfiguration {

    @Lazy
    @Bean
    public HelloDTO foo() {
        System.out.println("Foo bean dibuat");
        return new HelloDTO();
    }

    @Bean
    public WorldDTO bar() {
        System.out.println("Bar bean dibuat");
        return new WorldDTO();
    }
}
