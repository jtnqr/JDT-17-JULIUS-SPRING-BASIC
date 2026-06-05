package com.inidivaragroup.jdt17.spring.dasar.example.component;

import com.inidivaragroup.jdt17.spring.dasar.example.model.Bar;
import com.inidivaragroup.jdt17.spring.dasar.example.model.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FooBarQualifier {
    @Autowired
    @Qualifier("fooSecond")
    private Foo foo;

    @Autowired
    private Bar bar;

    public Foo getFoo() {
        return foo;
    }

    public Bar getBar() {
        return bar;
    }
}
