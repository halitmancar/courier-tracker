package com.halitmancar.couriertracker.controller;

import com.halitmancar.couriertracker.dto.RequestType;
import com.halitmancar.couriertracker.utils.TestHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.Instant;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class LocationTrackerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private final String baseURL = "/track";

    @Test
    void shouldPostTrackData() throws Exception {
        String url= baseURL;
        mockMvc.perform(MockMvcRequestBuilders
                        .post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(TestHelper.asJsonString(getFakeRequest())))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    public static RequestType getFakeRequest(){
        return RequestType.builder()
                .courierID(2)
                .time(Instant.now())
                .lat(41.046927)
                .lng(29.014921)
                .build();
    }
}
