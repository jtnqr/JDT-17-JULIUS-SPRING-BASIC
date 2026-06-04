package com.inidivaragroup.jdt17.spring.dasar.example.configuration;

import com.inidivaragroup.jdt17.spring.dasar.example.dto.WorldDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PrimaryBeanConfiguration {
    @Primary
    @Bean
    public WorldDTO world1() {
        return new WorldDTO();
    }

    @Bean
    public WorldDTO world2 () {
        return new WorldDTO();
    }
}
