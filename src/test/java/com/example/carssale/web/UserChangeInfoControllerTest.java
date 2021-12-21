package com.example.carssale.web;

import com.example.carssale.model.entity.UserEntity;
import com.example.carssale.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.Instant;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class UserChangeInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    private UserEntity userEntity;

    @BeforeEach
    void before() {
        userEntity = new UserEntity();
        userEntity
                .setCreated(Instant.now())
                .setModified(Instant.now());

        userEntity
                .setPassword(passwordEncoder.encode("1234567"))
                .setEmail("test123@abv.bg")
                .setLastName("test")
                .setFirstName("test");

        userRepository.save(userEntity);
    }

    @AfterEach
    void after() {
        userRepository.delete(userEntity);
    }

    @Test
//    @WithUserDetails("test123@abv.bg")
    void test() throws Exception {
        String encode = passwordEncoder.encode("1234566");
        mockMvc
                .perform(patch("/user/profile/edit")
                        .param("oldPassword", userEntity.getPassword())
                        .param("newPassword", encode)
                        .param("rePassword", encode)
                        .with(csrf()))
                .andExpect(status().is3xxRedirection());
//                .andExpect(view().name("/user/profile"));
    }


    @Test
    @WithUserDetails("admin@abv.bg")
    void testShowProfile() throws Exception {
        mockMvc.perform(get("/user/profile"))
                .andExpect(status().isOk())
                .andExpect(view().name("profile"));
    }

    @Test
    @WithUserDetails("admin@abv.bg")
    void testShowProfileEdit() throws Exception {
        mockMvc.perform(get("/user/profile/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("profile-edit"));
    }
}

