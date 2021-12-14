package com.example.carssale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CarsSaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarsSaleApplication.class, args);
    }

}
