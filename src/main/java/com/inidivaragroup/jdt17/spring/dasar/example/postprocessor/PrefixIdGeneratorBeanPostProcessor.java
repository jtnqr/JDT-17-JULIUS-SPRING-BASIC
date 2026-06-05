package com.inidivaragroup.jdt17.spring.dasar.example.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class PrefixIdGeneratorBeanPostProcessor implements BeanPostProcessor, Ordered {
    private final String prefix;

    public PrefixIdGeneratorBeanPostProcessor() {
        this.prefix = "PREFIX";
    }

    public PrefixIdGeneratorBeanPostProcessor(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof IdAware idAware) {
            idAware.setId(prefix + "-" + idAware.getId());
        }
        return bean;
    }
}
