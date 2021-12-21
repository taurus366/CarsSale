package com.example.carssale.service;

import com.example.carssale.model.binding.UserUpdateInfoBindingModel;
import com.example.carssale.model.dto.UserDTO;
import com.example.carssale.model.entity.UserEntity;
import com.example.carssale.model.service.UserRegistrationServiceModel;

import java.util.List;

public interface UserService {

    void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel);
    boolean isEmailExists(String email);
    boolean isAdmin(String email);

    UserDTO getUsernameByEmail(String userIdentifierEmail);

    boolean checkPasswordValid(String oldPassword,String email);

    List<UserDTO> getAllUsers();

    void patchPassword(UserUpdateInfoBindingModel userUpdateInfoBindingModel, String userEmail);
}
