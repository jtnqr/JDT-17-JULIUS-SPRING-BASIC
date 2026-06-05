package com.inidivaragroup.jdt17.spring.dasar.example.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class IdGeneratorBeanPostProcessor implements BeanPostProcessor, Ordered {
    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof IdAware) {
            ((IdAware) bean).setId(UUID.randomUUID().toString());
        }
        return bean;
    }
}
