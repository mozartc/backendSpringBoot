package com.aliyun.backendspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.aliyun.controller"})
public class BackendspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendspringbootApplication.class, args);
    }

}
