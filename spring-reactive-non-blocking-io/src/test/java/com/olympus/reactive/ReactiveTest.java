package com.olympus.reactive;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
//import org.testng.annotations.Test;



public class ReactiveTest extends BaseTest{
    private static final Logger Logger = LogManager.getLogger("test");
    // Spring Boot will create a `WebTestClient` for you,
    // already configure and ready to issue requests against "localhost:RANDOM_PORT"
//    @Autowired
//    private WebTestClient webTestClient;

//    @RepeatedTest(100)
    @Test
    public void testHello() {
        webClient
                // Create a GET request to test an endpoint
                .get()
                .uri("/hello")
                .accept(MediaType.TEXT_PLAIN)
                .exchange()
                // and use the dedicated DSL to test assertions against the response
                .expectStatus()
                .isOk()
                .expectBody(String.class)
                .isEqualTo("Hello, Spring Reactive!");

//        Logger.info("test passed");


    }
}


