package com.inidivaragroup.jdt17.spring.dasar.example.scope;

import com.inidivaragroup.jdt17.spring.dasar.example.model.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class PrototypeConfiguration {
    @Bean
    @Primary
    @Scope("prototype")
    public Foo foo() {
        return new Foo();
    }
}
