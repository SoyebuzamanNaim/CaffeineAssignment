package com.example.caffeine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CaffeineAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaffeineAssignmentApplication.class, args);
    }

}
