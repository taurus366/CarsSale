package com.example.carssale.web;

import com.example.carssale.model.entity.OfferEntity;
import static org.hamcrest.Matchers.hasSize;
import com.example.carssale.model.entity.UserEntity;
import com.example.carssale.repository.RegionRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RegionControllerTest {


    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
//        featureRepository.deleteAll();
//        pictureRepository.deleteAll();
//        userRepository.deleteAll();



    }

    @Test
//    @WithMockUser(username="admin",roles={"USER","ADMINISTRATOR"})
    void test() throws Exception {
        mockMvc
                .perform(get("/users/region"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(27)));
    }

    private void initOffer() {
//        offerEntity = new OfferEntity();


    }
}
