package com.example.carssale.web;

import com.example.carssale.model.binding.UserRegistrationBindingModel;
import com.example.carssale.model.entity.UserEntity;
import com.example.carssale.repository.CityVillageRepository;
import com.example.carssale.repository.RegionRepository;
import com.example.carssale.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private UserRegistrationBindingModel userRegistrationBindingModel;



    @Autowired
   private UserRepository userRepository;


    @BeforeEach
    void before() {
        userRegistrationBindingModel = new UserRegistrationBindingModel();
        userRegistrationBindingModel.setEmail("test1234@abv.bg")
                .setFirstName("test12")
                .setLastName("test12")
                .setPassword("test12")
                .setConfirmPassword("test12")
                .setPhone("0894396766")
                .setRegion("2")
                .setCityVillage("14");
    }

    @AfterEach
    void after() {


        List<UserEntity> all = userRepository
                .findAll();
        UserEntity userEntity = all
                .get(all.size() - 1);
        if (userEntity.getEmail().equals("test1234@abv.bg")){
            userRepository.delete(userEntity);
        }
    }

    @Test
    void test() throws Exception {
        mockMvc
                .perform(get("/users/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }

    @Test
    void testRegister() throws Exception {
        mockMvc.perform(post("/users/register").
                        param("firstName", "test1234@abv.bg").
                        param("lastName", "test1234").
                        param("email", "test1234@abv.bg").
                        param("password", "1234567").
                        param("confirmPassword", "1234567").
                        param("phone", "0894396766")
                        .param("region", "2")
                        .param("cityVillage", "14")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                ).
                andExpect(status().is3xxRedirection());


    }
}
