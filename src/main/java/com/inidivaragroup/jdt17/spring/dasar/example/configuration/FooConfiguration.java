package com.inidivaragroup.jdt17.spring.dasar.example.configuration;

import com.inidivaragroup.jdt17.spring.dasar.example.model.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class FooConfiguration {
    @Bean
    @Primary
    public Foo foo() {
        return new Foo();
    }
}
