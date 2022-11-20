package edu.eci.arsw.drawitapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Collections;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw"})
public class DrawitAPIApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DrawitAPIApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8080"));
        app.run(args);
    }
}