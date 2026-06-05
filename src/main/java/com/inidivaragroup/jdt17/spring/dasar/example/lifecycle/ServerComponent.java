package com.inidivaragroup.jdt17.spring.dasar.example.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class ServerComponent {
    @PostConstruct
    public void start() {
        System.out.println("ServerComponent: start - server dimulai");
    }

    @PreDestroy
    public void stop() {
        System.out.println("ServerComponent: stop - server dihentikan");
    }
}
