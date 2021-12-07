package com.example.carssale.model.service;

public class UserRegistrationServiceModel {
    private String firstName;
    private String lastName;
    private String cityVillage;
    private String email;
    private String phone;
    private String password;

    public UserRegistrationServiceModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegistrationServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegistrationServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getCityVillage() {
        return cityVillage;
    }

    public UserRegistrationServiceModel setCityVillage(String cityVillage) {
        this.cityVillage = cityVillage;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegistrationServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserRegistrationServiceModel setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
