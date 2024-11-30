package com.example.shopscanner_spring_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class ShopScannerSpringApiApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ShopScannerSpringApiApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8083"));//In my case postgres is already listening to port 8080
        app.run(args);


    }
}
 