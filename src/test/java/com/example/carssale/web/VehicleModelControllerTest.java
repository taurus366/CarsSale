package com.example.carssale.web;

import com.example.carssale.model.entity.BrandEntity;
import com.example.carssale.model.entity.ModelEntity;
import com.example.carssale.repository.BrandRepository;
import com.example.carssale.repository.ModelRepository;
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

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@AutoConfigureMockMvc
public class VehicleModelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private BrandRepository brandRepository;

    private ModelEntity modelEntity;
    private Boolean isCreated = false;
    private Long brandId;
    @BeforeEach
    void before() {
       brandId = brandRepository.findByBrandName("BMW").getId();
       if (brandId != null) {
           List<ModelEntity> allByBrand_id = modelRepository.findAllByBrand_Id(brandId);
           if (allByBrand_id == null) {
               isCreated = true;
              modelEntity = new ModelEntity();
               modelEntity
                       .setModelName("X6");
               modelRepository.save(modelEntity);
           }
       }


    }

    @AfterEach
    void after() {
    if (isCreated) {
        List<ModelEntity> x6 = modelRepository.findAllByBrand_Id(brandId)
                .stream().filter(modelEntity1 -> !modelEntity1.getModelName().equals("X6")).collect(Collectors.toList());
        modelRepository.saveAll(x6);
    }
    }

    @Test
    void test() throws Exception {
        mockMvc
                .perform(get("/users/model/" + brandId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].modelName",is("X6")));
    }
}
