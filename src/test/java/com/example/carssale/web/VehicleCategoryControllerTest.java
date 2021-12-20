package com.example.carssale.web;

import com.example.carssale.model.entity.BrandEntity;
import com.example.carssale.model.entity.VehicleCategoryEntity;
import com.example.carssale.model.entity.enums.VehicleCategoryEnum;
import com.example.carssale.repository.BrandRepository;
import com.example.carssale.repository.VehicleCategoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
public class VehicleCategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private VehicleCategoryRepository vehicleCategoryRepository;

    @Autowired
    private BrandRepository brandRepository;

    private BrandEntity brandEntity;
    private VehicleCategoryEntity vehicleCategoryEntity;
    public boolean isEmpty = false;

    @BeforeEach
    void before() {

      isEmpty = (vehicleCategoryEntity = vehicleCategoryRepository.findByVehicleCategoryName(VehicleCategoryEnum.CAR)) == null;

      if (isEmpty){
          vehicleCategoryEntity = new VehicleCategoryEntity();
          vehicleCategoryEntity
                  .setVehicleCategoryName(VehicleCategoryEnum.CAR);

          vehicleCategoryEntity = vehicleCategoryRepository.save(vehicleCategoryEntity);
      }

    }
    @AfterEach
    void after() {
        if (isEmpty) {
            vehicleCategoryRepository.delete(vehicleCategoryEntity);
        }
    }
    @Test
    void test() throws Exception {

        mockMvc
                .perform(get("/users/category"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].category",is("CAR")));
    }
}
