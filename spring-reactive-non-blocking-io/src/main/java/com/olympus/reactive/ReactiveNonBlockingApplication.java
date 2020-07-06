package com.olympus.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.olympus.reactive")
public class ReactiveNonBlockingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveNonBlockingApplication.class, args);
    }
}
