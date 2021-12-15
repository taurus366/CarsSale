package com.example.carssale.service;

import com.example.carssale.model.dto.UserDTO;
import com.example.carssale.model.entity.UserEntity;
import com.example.carssale.model.service.UserRegistrationServiceModel;

public interface UserService {

    void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel);
    boolean isEmailExists(String email);
    boolean isAdmin(String email);

    UserDTO getUsernameByEmail(String userIdentifierEmail);
}
