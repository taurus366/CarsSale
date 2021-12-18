package com.example.carssale.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserUpdateInfoBindingModel {

    @NotNull
    @NotBlank
    @Size(min = 3,max = 12)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min = 3,max = 12)
    private String lastName;

    @NotNull
    @NotBlank
    @Size(min = 5,max = 12)
    private String oldPassword;

    @NotNull
    @NotBlank
    @Size(min = 5,max = 12)
    private String newPassword;

    @NotNull
    @NotBlank
    @Size(min = 5,max = 12)
    private String rePassword;

    @NotNull
    @NotBlank
    @Size(min = 10)
    private String phone;


    public String getFirstName() {
        return firstName;
    }

    public UserUpdateInfoBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserUpdateInfoBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public UserUpdateInfoBindingModel setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
        return this;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public UserUpdateInfoBindingModel setNewPassword(String newPassword) {
        this.newPassword = newPassword;
        return this;
    }

    public String getRePassword() {
        return rePassword;
    }

    public UserUpdateInfoBindingModel setRePassword(String rePassword) {
        this.rePassword = rePassword;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserUpdateInfoBindingModel setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
