package com.inidivaragroup.jdt17.spring.dasar.example.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Connection implements InitializingBean, DisposableBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Connection: afterPropertiesSet - siap digunakan");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Connection: destroy - koneksi ditutup");
    }
}
