package com.inidivaragroup.jdt17.spring.dasar.example.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
    @Autowired
    private ApplicationEventPublisher publisher;

    public void login(String username) {
        System.out.println("Login: " + username);
        publisher.publishEvent(new LoginEvent(this, username));
    }

    public ApplicationEventPublisher getPublisher() {
        return publisher;
    }
}
