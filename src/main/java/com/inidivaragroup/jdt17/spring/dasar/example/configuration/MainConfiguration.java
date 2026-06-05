package com.inidivaragroup.jdt17.spring.dasar.example.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({FooConfiguration.class, BarConfiguration.class})
public class MainConfiguration {
}
