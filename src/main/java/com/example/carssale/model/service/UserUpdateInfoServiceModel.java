package com.example.carssale.model.service;

public class UserUpdateInfoServiceModel {

    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public UserUpdateInfoServiceModel setNewPassword(String newPassword) {
        this.newPassword = newPassword;
        return this;
    }
}
