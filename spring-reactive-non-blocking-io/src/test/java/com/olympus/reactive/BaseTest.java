//package com.olympus.reactive;
//
//
//import lombok.extern.log4j.Log4j2;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.context.annotation.ComponentScan;
////import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
//import org.springframework.core.env.Environment;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestExecutionListeners;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.springframework.test.web.reactive.server.WebTestClient;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.reactive.function.client.WebClient;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
//
////@EnableCouchbaseRepositories(basePackages = {"com.olympus.blocking"})
//
///**
// * As the test context framework caches context, JMX is disabled by default to prevent identical components to register on the same domain. If such test needs access to an MBeanServer, consider marking it dirty as well
// */
//
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)//(properties = "spring.jmx.enabled=true")
//@AutoConfigureWebTestClient
//@TestPropertySource(properties = "server.port=8080")
//public abstract class BaseTest extends AbstractTestNGSpringContextTests {
//
//    @LocalServerPort
//    private int port;
//
//
//    @Autowired
//    protected WebTestClient webClient;
//
////    @BeforeSuite
////    public void setupCOuchbase(){
////
////    }
////    @Autowired
////    protected N1QLPersonRepository personRepository;
//
////    @Autowired
////    Environment environment;
////
////    private final String port = environment.getProperty("local.server.port");
//
//    protected WebClient client;
//
//
//    @BeforeTest
//    public void deleteAll(){
//         client = WebClient.create("http://localhost:"+port);
//        System.out.println("before cycle");
////        businessUnityRepository.deleteAll();
//    }
//
//}