package com.akata.studentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServiceStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceStudentApplication.class, args);
    }

}
