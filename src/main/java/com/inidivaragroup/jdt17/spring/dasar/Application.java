package com.inidivaragroup.jdt17.spring.dasar;

import com.inidivaragroup.jdt17.spring.dasar.example.listener.AppStartingListener;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.addListeners(new AppStartingListener());
        app.run(args);
    }
}
