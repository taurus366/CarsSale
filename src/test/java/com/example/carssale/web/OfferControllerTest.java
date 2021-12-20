package com.example.carssale.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.example.carssale.model.entity.OfferEntity;
import com.example.carssale.model.entity.UserEntity;
import com.example.carssale.repository.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;

@SpringBootTest
@AutoConfigureMockMvc
public class OfferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private CityVillageRepository cityVillageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private FeatureRepository featureRepository;

    private UserEntity userEntity;
    private OfferEntity offerEntity;

    @BeforeEach
    void setUp() {
        userEntity = new UserEntity();
        userEntity
                .setPassword("password")
                .setFirstName("ali")
                .setLastName("ali")
                .setEmail("ali2222@abv.bg")
                .setCreated(Instant.now())
                .setModified(Instant.now());

        userEntity = userRepository.save(userEntity);

        offerEntity = new OfferEntity();
        offerEntity
                .setUser(userEntity);
        offerEntity
                .setModified(Instant.now())
                .setCreated(Instant.now());

        offerEntity = offerRepository
                .save(offerEntity);
    }

    @Test
    @WithMockUser(username="admin@abv.bg",roles={"USER","ADMINISTRATOR"})
    void testGetOfferByID() throws Exception {
        mockMvc
                .perform(get("/users/offers/"+ offerEntity.getId()))
                .andExpect(status().isOk());
    }

    @AfterEach
    void tearDown() {
//        featureRepository.deleteAll();
//        pictureRepository.deleteAll();
        offerRepository.delete(offerEntity);
        userRepository.delete(userEntity);

    }

    @Test
    @WithMockUser(username="admin",roles={"USER","ADMINISTRATOR"})
    void test() throws Exception {
        mockMvc
                .perform(get("/users/offers/all"))
                .andExpect(status().isOk());
    }




}
