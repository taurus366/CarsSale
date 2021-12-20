package com.example.carssale.web;

import com.example.carssale.model.entity.BrandEntity;
import com.example.carssale.model.entity.VehicleCategoryEntity;
import com.example.carssale.model.entity.enums.VehicleCategoryEnum;
import com.example.carssale.repository.BrandRepository;
import com.example.carssale.repository.VehicleCategoryRepository;
import com.example.carssale.repository.VehicleCoupeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VehicleBrandControllerTest {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private VehicleCategoryRepository vehicleCategoryRepository;

    private BrandEntity brandEntity;
    private VehicleCategoryEntity vehicleCategoryEntity;
    public boolean isEmpty = false;
    @BeforeEach
    void before() {
      isEmpty = vehicleCategoryRepository.findByVehicleCategoryName(VehicleCategoryEnum.CAR) == null;
        if (isEmpty) {
            vehicleCategoryEntity = new VehicleCategoryEntity();
            vehicleCategoryEntity
                    .setVehicleCategoryName(VehicleCategoryEnum.CAR);

          vehicleCategoryEntity = vehicleCategoryRepository.save(vehicleCategoryEntity);
        }else {
            vehicleCategoryEntity = vehicleCategoryRepository.findByVehicleCategoryName(VehicleCategoryEnum.CAR);
        }

    }

    @AfterEach
    void after() {
        brandRepository.delete(brandEntity);
       if (isEmpty) {
           vehicleCategoryRepository.delete(vehicleCategoryEntity);
       }
    }

    @Test
    void test() throws Exception {
//        List<BrandEntity> BMW = brandRepository.findAllByCategory_Id(vehicleCategoryEntity.getId())
//                .stream().filter(brandEntity1 -> brandEntity1.getBrandName().equals("BMW"))
//                .collect(Collectors.toList());
//        if (BMW.size() == 0) {
            brandEntity = new BrandEntity();
            brandEntity = brandEntity
                    .setCategory(vehicleCategoryEntity)
                    .setBrandName("TEST");

            brandEntity = brandRepository.save(brandEntity);
//        } else {
//            brandEntity = BMW.get(0);
//        }


        mockMvc
                    .perform(get("/users/brand/"+vehicleCategoryEntity.getId()))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.[3].brandName", is(brandEntity.getBrandName())));
//                    .andExpect(jsonPath("$.[0]",is(brandEntity)));

    }
}
