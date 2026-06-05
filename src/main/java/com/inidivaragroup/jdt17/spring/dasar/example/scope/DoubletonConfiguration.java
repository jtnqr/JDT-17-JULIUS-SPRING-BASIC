package com.inidivaragroup.jdt17.spring.dasar.example.scope;

import com.inidivaragroup.jdt17.spring.dasar.example.model.Bar;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DoubletonConfiguration {
    @Bean
    public CustomScopeConfigurer customScopeConfigurer() {
        var configurer = new CustomScopeConfigurer();
        configurer.addScope("doubleton", new DoubletonScope());
        return configurer;
    }

    @Bean
    @Scope("doubleton")
    public Bar bar() {
        return new Bar();
    }
}
