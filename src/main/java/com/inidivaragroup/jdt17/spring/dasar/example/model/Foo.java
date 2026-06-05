package com.inidivaragroup.jdt17.spring.dasar.example.model;

import com.inidivaragroup.jdt17.spring.dasar.example.postprocessor.IdAware;

public class Foo implements IdAware {
    private String id;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
