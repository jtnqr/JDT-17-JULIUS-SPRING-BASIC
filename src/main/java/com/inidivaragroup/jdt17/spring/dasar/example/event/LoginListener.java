package com.inidivaragroup.jdt17.spring.dasar.example.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class LoginListener implements ApplicationListener<LoginEvent> {
    @Override
    public void onApplicationEvent(LoginEvent event) {
        System.out.println("LoginListener (Interface): User login: " + event.getUsername());
    }
}
