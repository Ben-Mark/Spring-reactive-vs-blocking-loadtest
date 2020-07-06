package com.olympus.reactive;

import com.olympus.reactive.service.GreetingHandler;
//import com.olympus.reactive.service.ReactiveController;
import com.olympus.reactive.service.ReactiveController;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
//import org.testng.annotations.BeforeClass;

//@AutoConfigureWebTestClient
//@ExtendWith(SpringExtension.class)
////  We create a `@SpringBootTest`, starting an actual server on a `RANDOM_PORT`
//
////@ExtendWith(SpringExtension.class)
//@WebFluxTest(controllers = ReactiveController.class)
////@Import(EmployeeService.class)
//@WithMockUser
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@WithMockUser
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient

//@Import(ReactiveNonBlockingApplication.class)
public abstract class BaseTest {

    @Autowired
    protected WebTestClient webClient;

//    @BeforeClass
//    public void init(){
////        WebTestClient testClient = WebTestClient.bindToApplicationContext(context)
////                .build();
//    }

}
