package com.example.carssale.service.impl;

import com.example.carssale.model.entity.RoleEntity;
import com.example.carssale.model.entity.UserEntity;
import com.example.carssale.model.entity.enums.RoleEnum;
import com.example.carssale.repository.UserRepository;
import com.example.carssale.service.Impl.CarsSaleUserServiceImpl;
import com.example.carssale.service.Impl.UserServiceImpl;
import com.example.carssale.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class CarsSaleUserDetailsServiceTest {

    private UserEntity testUser;
    private RoleEntity adminRole, userRole;

    private CarsSaleUserServiceImpl serviceToTest;
    private UserService userService;


    @Mock
    private UserRepository mockUserRepository;


    @BeforeEach
    void init() {
        serviceToTest = new CarsSaleUserServiceImpl(mockUserRepository);
        adminRole = new RoleEntity();
        adminRole.setRole(RoleEnum.ADMINISTRATOR);

        userRole = new RoleEntity();
        userRole.setRole(RoleEnum.USER);

        testUser = new UserEntity();
        testUser
                .setFirstName("admin")
                .setLastName("admin")
                .setEmail("test@abv.bg")
                .setPassword("1234567")
                .setRole(List.of(adminRole));
    }

    @Test
    public void setTestUserNotFound() {
        Assertions.assertThrows(
                UsernameNotFoundException.class,
                () -> serviceToTest.loadUserByUsername("admin@abv.bg")
        );
    }

    @Test
    public void setTestUserFound() {
        Mockito.when(mockUserRepository.findByEmail(testUser.getEmail()))
                .thenReturn(Optional.of(testUser));


        UserDetails userDetails = serviceToTest.loadUserByUsername(testUser.getEmail());
        System.out.println(serviceToTest.loadUserByUsername("test@abv.bg"));

        System.out.println(userDetails.getUsername());
        String expectedRoles = "ROLE_ADMINISTRATOR";
        String actualRoles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(
                Collectors.joining(", "));

        System.out.println(actualRoles);
        Assertions.assertEquals(userDetails.getUsername(), testUser.getEmail());
        Assertions.assertEquals(expectedRoles, actualRoles);

    }

}
