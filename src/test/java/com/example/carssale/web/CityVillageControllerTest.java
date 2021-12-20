package com.example.carssale.web;

import com.example.carssale.model.entity.RegionEntity;
import com.example.carssale.repository.CityVillageRepository;
import com.example.carssale.repository.RegionRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
@AutoConfigureMockMvc
public class CityVillageControllerTest {

    @Autowired
    private CityVillageRepository cityVillageRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private MockMvc mockMvc;


    @BeforeEach
    void setUp() {


    }
    @AfterEach
    void tearDown() {

    }
    @Test
  void test() throws Exception {


        mockMvc
                .perform(get("/users/cityVillage/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(13)))
                .andExpect(jsonPath("$.[0].cityVillageName", is("Банско")));
    }

    @Test
    void testException() throws Exception {
        mockMvc
                .perform(get("/users/cityVillage/99"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(0)));
    }
}
