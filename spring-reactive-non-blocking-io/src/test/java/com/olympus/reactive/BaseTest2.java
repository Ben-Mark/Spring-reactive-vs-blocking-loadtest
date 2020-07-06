package com.olympus.reactive;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.BeforeTest;

//@EnableCouchbaseRepositories(basePackages = {"com.olympus.blocking"})

/**
 * As the test context framework caches context, JMX is disabled by default to prevent identical components to register on the same domain. If such test needs access to an MBeanServer, consider marking it dirty as well
 */
@SpringBootTest//(properties = "spring.jmx.enabled=true")
//@DirtiesContext
@AutoConfigureWebTestClient
public abstract class BaseTest2 extends AbstractTestNGSpringContextTests {

    @Autowired
    protected WebTestClient webClient;

    @BeforeTest
    public void deleteAll(){
        System.out.println("before cycle");
//        businessUnityRepository.deleteAll();
    }

}