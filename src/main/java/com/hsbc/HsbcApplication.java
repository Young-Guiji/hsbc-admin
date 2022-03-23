package com.hsbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class HsbcApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(HsbcApplication.class, args);
    }

}
