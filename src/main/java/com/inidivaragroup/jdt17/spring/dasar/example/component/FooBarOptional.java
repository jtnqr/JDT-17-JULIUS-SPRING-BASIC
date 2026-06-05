package com.inidivaragroup.jdt17.spring.dasar.example.component;

import com.inidivaragroup.jdt17.spring.dasar.example.model.Foo;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class FooBarOptional {
    @Autowired(required = false)
    private Foo foo;

    @Autowired
    private Optional<Foo> optionalFoo;

    @Autowired
    private ObjectProvider<Foo> fooProvider;

    public Foo getFoo() {
        return foo;
    }

    public Optional<Foo> getOptionalFoo() {
        return optionalFoo;
    }

    public ObjectProvider<Foo> getFooProvider() {
        return fooProvider;
    }
}
