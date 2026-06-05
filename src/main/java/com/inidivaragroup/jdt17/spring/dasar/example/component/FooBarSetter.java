package com.inidivaragroup.jdt17.spring.dasar.example.component;

import com.inidivaragroup.jdt17.spring.dasar.example.model.Bar;
import com.inidivaragroup.jdt17.spring.dasar.example.model.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FooBarSetter {
    private Foo foo;
    private Bar bar;

    @Autowired
    public void setFoo(Foo foo) {
        this.foo = foo;
    }

    @Autowired
    public void setBar(Bar bar) {
        this.bar = bar;
    }

    public Foo getFoo() {
        return foo;
    }

    public Bar getBar() {
        return bar;
    }
}
