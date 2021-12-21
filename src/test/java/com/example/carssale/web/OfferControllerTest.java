package com.example.carssale.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.carssale.exception.OfferNotFoundException;
import com.example.carssale.model.entity.ModelEntity;
import com.example.carssale.model.entity.OfferEntity;
import com.example.carssale.model.entity.UserEntity;
import com.example.carssale.model.entity.enums.*;
import com.example.carssale.repository.*;
import com.example.carssale.service.Impl.CarsSaleUser;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class OfferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OfferRepository offerRepository;

    @Autowired
    private OfferRepository testOfferRepository;

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

    @Autowired
    private ModelRepository modelRepository;

    private UserEntity userEntity;
    private OfferEntity offerEntity;
    private List<OfferEntity> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
        when(offerRepository.findAll())
                .thenReturn(list);


//        userEntity = new UserEntity();
//        userEntity
//                .setPassword("password")
//                .setFirstName("ali")
//                .setLastName("ali")
//                .setEmail("ali2222@abv.bg")
//                .setCreated(Instant.now())
//                .setModified(Instant.now());
//
//        userEntity = userRepository.save(userEntity);


        offerEntity = new OfferEntity();
        offerEntity
                .setUser(userEntity);
        offerEntity
                .setModified(Instant.now())
                .setCreated(Instant.now());

//        offerEntity = offerRepository
//                .save(offerEntity);
        userEntity = userRepository.findAll().get(0);
        offerEntity = new OfferEntity();
        offerEntity
                .setUser(userEntity);
        offerEntity
                .setModified(Instant.now())
                .setCreated(Instant.now());
        offerEntity.setDoorCount(1)
                .setKilometer(324234)
                .setPower(32432)
                .setModification("32432")
                .setStatusUsed(StatusUsedEnum.USED)
                .setFuelType(FuelTypeEnum.DIESEL)
                .setCarCoupe(VehicleCoupeEnum.COUPE)
                .setEmissionClass("EURO5")
                .setTransmission(TransmisionEnum.AUTOMATIC)
                .setVehicleStatus(VehicleStatusEnum.GOOD)
                .setPriceType(PriceTypeEnum.BGN)
                .setPrice(234243)
                .setExteriorColor(ExteriorColorEnum.RED)
                        .setId(1L);
        list.add(offerEntity);
//        offerEntity = testOfferRepository
//                .save(offerEntity);
    }

    @Test
    void test2() {
        list.clear();
        List<OfferEntity> all = offerRepository.findAll();
        assertEquals(0, all.size());
    }


    @Test
    public void testFindOneEventsWhenOneEventsThenAddId() {
        list.clear();

        OfferEntity offer = new OfferEntity();

        list.add(offer);

        List<OfferEntity> results = offerRepository.findAll();
        assertEquals(1, results.size());
    }


    @Test
    public void testCreateVehicleWhenUserIsNullThrow() {
        assertEquals(0, offerRepository.findAllByUserEmail("").size());
    }


    @AfterEach
    void tearDown() {
//        featureRepository.deleteAll();
//        pictureRepository.deleteAll();
//        offerRepository.delete(offerEntity);
//        userRepository.delete(userEntity);

    }

    @Test
    @WithUserDetails("admin@abv.bg")
    void test5() throws Exception {

//        ModelEntity modelEntity = modelRepository.findAllByBrand_Id(1L).get(0);

        mockMvc
                .perform(post("/users/offers/add")
                        .param("doorCount", "1")
                        .param("emissionClass", "EURO5")
                        .param("vehicleYear", "1994")
                        .param("price", "123324")
                        .param("modification", "EURO5")
                        .param("kilometer", "234234")
                        .param("power", "324")
                        .param("vehicleStatus", "GOOD")
                        .param("statusUsed", "USED")
                        .param("carCoupe", "SEDAN")
                        .param("exteriorColor", "RED")
                        .param("fuelType", "GAS")
                        .param("model", "1")
                        .param("priceType", "BGN")
                        .param("transmission", "AUTOMATIC")
                        .param("brand", "1")
                        .param("picture", String.valueOf(new ArrayList<>()))
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection());
    }

//    @Test
//    @WithUserDetails("admin@abv.bg")
//    void testIsOk() throws Exception {
//
//        mockMvc
//                .perform(get("/users/offers/all"))
//                .andExpect(status().isOk());
//    }

    @Test
    @WithUserDetails("admin@abv.bg")
    void testOk() throws Exception {
//        OfferEntity offerEntity = testOfferRepository.findAll().get(0);
        mockMvc
                .perform(get("/users/offers/myOffers"))
                .andExpect(status().isOk());
    }

    @Test
    @WithUserDetails("admin@abv.bg")
    void testReturnCreateOfferPage() throws Exception {
        mockMvc
                .perform(get("/users/offers/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("create-offer"));
    }

    @Test
    @WithUserDetails("admin@abv.bg")
    void testForAdminStatistics() throws Exception {
        mockMvc
                .perform(get("/admin/statistics"))
                .andExpect(status().isOk());
    }

    @Test
    @WithUserDetails("admin@abv.bg")
    void testForAdminUsers() throws Exception {
        mockMvc
                .perform(get("/admin/view/all"))
                .andExpect(status().isOk());
    }


}
