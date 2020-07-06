package com.olympus.blocking;

import com.olympus.blocking.couchbase.repo.BuildingRepository;
import com.olympus.blocking.service.BlockingController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.BeforeTest;

@EnableCouchbaseRepositories(basePackages = {"com.olympus.blocking"})
@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest
public abstract class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected BuildingRepository businessUnityRepository;

    @Autowired
    protected MockMvc mockMvc;


    @BeforeTest
    public void deleteAll(){
        System.out.println("before cycle");
//        businessUnityRepository.deleteAll();
    }

}