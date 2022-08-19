package com.akata.studentservice;

import com.akata.studentservice.configuration.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class ServiceStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceStudentApplication.class, args);
    }

}
