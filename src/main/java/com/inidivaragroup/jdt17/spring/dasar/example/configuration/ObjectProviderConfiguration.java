package com.inidivaragroup.jdt17.spring.dasar.example.configuration;

import com.inidivaragroup.jdt17.spring.dasar.example.component.FooBarOptional;
import com.inidivaragroup.jdt17.spring.dasar.example.model.Bar;
import com.inidivaragroup.jdt17.spring.dasar.example.model.Foo;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectProviderConfiguration {
    @Bean
    public Bar bar() {
        return new Bar();
    }

    @Bean
    public FooBarOptional fooBar(ObjectProvider<Foo> fooProvider) {
        return new FooBarOptional();
    }
}
