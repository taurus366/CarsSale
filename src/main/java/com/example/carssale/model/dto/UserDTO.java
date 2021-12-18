package com.example.carssale.model.dto;

public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String cityVillageName;
    private String region;

    public Long getId() {
        return id;
    }

    public UserDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getCityVillageName() {
        return cityVillageName;
    }

    public UserDTO setCityVillageName(String cityVillageName) {
        this.cityVillageName = cityVillageName;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public UserDTO setRegion(String region) {
        this.region = region;
        return this;
    }
}
