package com.inidivaragroup.jdt17.spring.dasar.example.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LogCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Argumen dari command line:");
        for (String arg : args) {
            System.out.println("- " + arg);
        }
    }
}
