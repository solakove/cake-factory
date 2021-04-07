package com.eds.cakefactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CakeFactoryApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CakeFactoryApplication.class, args);
    }

}
