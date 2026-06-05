package com.inidivaragroup.jdt17.spring.dasar.example.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LoginAnnotationListener {
    @EventListener
    public void onLoginEvent(LoginEvent event) {
        System.out.println("LoginAnnotationListener (Annotation): User login: " + event.getUsername());
    }
}
