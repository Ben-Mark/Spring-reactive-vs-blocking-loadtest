package com.olympus.blocking;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.olympus.blocking.couchbase.model.Building;
import com.olympus.blocking.couchbase.service.BuildingService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LoadTestBlocking extends BaseTest {


    public static final String BUILDING_1 = "building::1";
    public static final String COMPANY_2 = "company::2";

    @Autowired
    private BuildingService buildingService;


//    @DataProvider
//    public Object[][] integerProvider() {
////        double[][] result = Arrays.stream(new ArrayList<Integer>).map(r ->
////                IntStream.range(0, m2[0].length).mapToDouble(i ->
////                        IntStream.range(0, m2.length).mapToDouble(j -> r[j] * m2[j][i]).sum()
////                ).toArray()).toArray(double[][]::new);
//
////        List<Integer> users = IntStream.range(0, 5)
////                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//////                .collect(Collectors.toList());
//
//       return IntStream.range(0, 1000)
//                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll)
//                .stream()
//                .map(i -> new Object[]{i})
//                .toArray(Object[][]::new);
//
////        return new Object[][]{
////                {1},
////                {2},
////                {3},
////                {4},
////                {5},
////                {6},
////                {7},
////        };
//    }

    @Test( singleThreaded=true, invocationCount = 1)//dataProvider = "integerProvider")
    public void test1() throws Exception {
        val building = Building.builder()
                .id(BUILDING_1)
                .name("couchbase")
                .companyId(COMPANY_2)
                .phoneNumbers( new ArrayList<>())
                .areas(new ArrayList<>())
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String payload = objectMapper.writeValueAsString(building);

        mockMvc.perform(post("/save-object-blocking")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Item saved successfully"));

        this.mockMvc.perform(get("/get-object-blocking")
                .contentType(MediaType.APPLICATION_JSON)
                .queryParam("id",BUILDING_1))
                .andDo(print())
                .andExpect(status().isOk());
//                .andExpect(content().string("Item saved successfully"));
    }

}