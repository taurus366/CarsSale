package com.example.carssale.service.Impl;

import com.example.carssale.model.dto.UserDTO;
import com.example.carssale.model.entity.CityVillageEntity;
import com.example.carssale.model.entity.RoleEntity;
import com.example.carssale.model.entity.UserEntity;
import com.example.carssale.model.entity.enums.RoleEnum;
import com.example.carssale.model.service.UserRegistrationServiceModel;
import com.example.carssale.repository.CityVillageRepository;
import com.example.carssale.repository.RegionRepository;
import com.example.carssale.repository.RoleRepository;
import com.example.carssale.repository.UserRepository;
import com.example.carssale.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RegionRepository regionRepository;
    private final CityVillageRepository cityVillageRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final CarsSaleUserServiceImpl carsSaleUserService;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, RegionRepository regionRepository, CityVillageRepository cityVillageRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, CarsSaleUserServiceImpl carsSaleUserService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.regionRepository = regionRepository;
        this.cityVillageRepository = cityVillageRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.carsSaleUserService = carsSaleUserService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerAndLoginUser(UserRegistrationServiceModel userServiceModel) {

        RoleEntity userRole = roleRepository.findByRole(RoleEnum.USER);
        CityVillageEntity cityVillage = cityVillageRepository.getById(Long.parseLong(userServiceModel.getCityVillage()));

        UserEntity user = new UserEntity();

        user
                .setModified(Instant.now())
                .setCreated(Instant.now());

        user
                .setFirstName(userServiceModel.getFirstName())
                .setLastName(userServiceModel.getLastName())
                .setCityVillage(cityVillage)
                .setEmail(userServiceModel.getEmail())
                .setPhone(userServiceModel.getPhone())
                .setPassword(passwordEncoder.encode(userServiceModel.getPassword()))
                .setActive(true)
                .getRole().add(userRole);


        userRepository.save(user);

        UserDetails userDetails = carsSaleUserService.loadUserByUsername(user.getEmail());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails,
                user.getPassword(),
                userDetails.getAuthorities()
        );
        SecurityContextHolder
                .getContext()
                .setAuthentication(authentication);
    }

    @Override
    public boolean isEmailExists(String email) {
       try {
           userRepository.findByEmail(email).orElseThrow();
       }catch (Exception e){
           return false;
       }
        return true;
    }

    @Override
    public boolean isAdmin(String email) {

        return userRepository
                .findByEmail(email).orElseThrow()
                .getRole()
                .stream()
                .map(RoleEntity::getRole)
                .anyMatch(role -> role.equals(RoleEnum.ADMINISTRATOR));

//        AtomicBoolean isAdmin = new AtomicBoolean(false);
//
//         userRepository.findByEmail(email)
//                 .orElseThrow()
//                 .getRole()
//                 .forEach(roleEntity -> {
//                     if (roleEntity.getRole().name().equals("ADMINISTRATOR")) {
//                         isAdmin.set(true);
//                     }
//                 });
//        return isAdmin.get();
    }

    @Override
    public UserDTO getUsernameByEmail(String userIdentifierEmail) {

        UserEntity userEntity = userRepository.findByEmail(userIdentifierEmail)
                .get();

        UserDTO map = modelMapper.map(userEntity, UserDTO.class);

        map
                .setEmail(userEntity.getEmail())
                .setPhone(userEntity.getPhone())
                .setCityVillageName(userEntity.getCityVillage().getCityVillageName())
                .setRegion(userEntity.getCityVillage().getRegion().getRegionName());

        return map;
    }

    @Override
    public boolean checkPasswordValid(String oldPassword,String email) {

        Optional<UserEntity> byEmail = userRepository.findByEmail(email);
        boolean isValidPassword = passwordEncoder.matches(oldPassword,byEmail.get().getPassword());

        return isValidPassword;
    }
}
