package com.inidivaragroup.jdt17.spring.dasar.example.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class FooBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactory dimodifikasi sebelum bean dibuat");
        try {
            BeanDefinition definition = beanFactory.getBeanDefinition("foo");
            definition.setScope("prototype");
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("Bean definition 'foo' tidak ditemukan.");
        }
    }
}
