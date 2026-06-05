package com.inidivaragroup.jdt17.spring.dasar.example.component;

import com.inidivaragroup.jdt17.spring.dasar.example.model.Bar;
import com.inidivaragroup.jdt17.spring.dasar.example.model.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FooBarConstructor {
    private final Foo foo;
    private final Bar bar;

    public FooBarConstructor(Foo foo) {
        this.foo = foo;
        this.bar = null;
    }

    @Autowired
    public FooBarConstructor(Foo foo, Bar bar) {
        this.foo = foo;
        this.bar = bar;
    }

    public Foo getFoo() {
        return foo;
    }

    public Bar getBar() {
        return bar;
    }
}
