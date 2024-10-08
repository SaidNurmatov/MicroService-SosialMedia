package com.devsaid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class UserMicroService {
    public static void main(String[] args) {
        SpringApplication.run (UserMicroService.class);
    }
}
