package com.inidivaragroup.jdt17.spring.dasar.example.aware;

import com.inidivaragroup.jdt17.spring.dasar.example.model.Foo;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MyComponent implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.applicationContext = ctx;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void doSomething() {
        Foo foo = applicationContext.getBean(Foo.class);
        System.out.println("MyComponent: " + foo);
    }
}
