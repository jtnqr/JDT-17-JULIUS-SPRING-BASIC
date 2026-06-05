package com.inidivaragroup.jdt17.spring.dasar.example.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import java.util.LinkedHashMap;
import java.util.Map;

public class DoubletonScope implements Scope {
    private final Map<String, Object> objects = new LinkedHashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (objects.size() >= 2) {
            int index = objects.size() % 2;
            return objects.values().toArray()[index];
        }
        Object object = objectFactory.getObject();
        objects.put(name + objects.size(), object);
        return object;
    }

    @Override
    public Object remove(String name) {
        return objects.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        // Do nothing
    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
