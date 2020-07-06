package com.olympus.reactive;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
//import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//@Execution(ExecutionMode.CONCURRENT)
public class ReactiveTest2 extends BaseTest2 {

//    @Autowired
//    private MockMvc mockMvc;

    public static final String BUILDING_1 = "building::1";
    public static final String COMPANY_2 = "company::2";



//    @RepeatedTest(100)
//    @Test
//    public void testSave() throws Exception {
//        val building = Building.builder()
//                .id(BUILDING_1)
//                .name("couchbase")
//                .companyId(COMPANY_2)
//                .phoneNumbers( new ArrayList<>())
//                .areas(new ArrayList<>())
//                .build();
//
//
//        Building newBuilding = buildingService.findById(BUILDING_1).orElseThrow(()-> new Exception("Test failure: couchbase document doesnt exist right-after insertion"));
//        assertThat(newBuilding, equalTo(building));
//    }

    @DataProvider
    public Object[][] integerProvider() {
//        double[][] result = Arrays.stream(new ArrayList<Integer>).map(r ->
//                IntStream.range(0, m2[0].length).mapToDouble(i ->
//                        IntStream.range(0, m2.length).mapToDouble(j -> r[j] * m2[j][i]).sum()
//                ).toArray()).toArray(double[][]::new);

//        List<Integer> users = IntStream.range(0, 5)
//                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
////                .collect(Collectors.toList());

        return IntStream.range(0, 1000)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll)
                .stream()
                .map(i -> new Object[]{i})
                .toArray(Object[][]::new);

//        return new Object[][]{
//                {1},
//                {2},
//                {3},
//                {4},
//                {5},
//                {6},
//                {7},
//        };
    }

    @Test( singleThreaded=true, invocationCount = 1000)//dataProvider = "integerProvider")
    public void test1() throws Exception {
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
//        val building = Building.builder()
//                .id(BUILDING_1)
//                .name("couchbase")
//                .companyId(COMPANY_2)
//                .phoneNumbers( new ArrayList<>())
//                .areas(new ArrayList<>())
//                .build();

//        ObjectMapper objectMapper = new ObjectMapper();
//        String payload = objectMapper.writeValueAsString(building);
//
//        mockMvc.perform(post("/save-object-blocking")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(payload))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string("Item saved successfully"));

//        this.mockMvc.perform(get("/hello")
//                .contentType(MediaType.APPLICATION_JSON))
////                .queryParam("id",BUILDING_1))
//                .andDo(print())
//                .andExpect(status().isOk());
//                .andExpect(content().string("Item saved successfully"));
    }

}