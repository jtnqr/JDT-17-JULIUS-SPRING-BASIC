package com.inidivaragroup.jdt17.spring.dasar.example.configuration;


import com.inidivaragroup.jdt17.spring.dasar.example.dto.HelloDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanNameConfiguration {
    @Bean(name = "helloSatuBean")
    public HelloDTO helloDTO1() {
        return new HelloDTO();
    }

    @Bean(name = "helloDuaBean")
    public HelloDTO helloDTO2() {
        return new HelloDTO();
    }
}
