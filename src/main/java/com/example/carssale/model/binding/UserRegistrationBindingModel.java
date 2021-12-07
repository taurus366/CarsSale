package com.example.carssale.model.binding;
import javax.validation.constraints.*;

public class UserRegistrationBindingModel {

    @NotNull
    @Size(min = 3,max = 12)
    private String firstName;

    @NotNull
    @Size(min = 3,max = 12)
    private String lastName;

    @NotNull
    private String cityVillage;

    @NotNull
    @NotBlank
    private String region;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 10)
    private String phone;

    @NotNull
    @Size(min = 5,max = 12)
    private String password;

    @NotNull
    @Size(min = 5,max = 12)
    private String confirmPassword;

    public String getFirstName() {
        return firstName;
    }

    public UserRegistrationBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegistrationBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getCityVillage() {
        return cityVillage;
    }

    public UserRegistrationBindingModel setCityVillage(String cityVillage) {
        this.cityVillage = cityVillage;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public UserRegistrationBindingModel setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegistrationBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserRegistrationBindingModel setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegistrationBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
