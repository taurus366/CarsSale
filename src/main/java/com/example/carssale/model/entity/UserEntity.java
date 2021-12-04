package com.example.carssale.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

    private String firstName;
    private String lastName;
    private String cityVillageName;
    private String region;
    @Column(unique = true, nullable = false)
    private String email;
    private String phone;
    private String password;
    private boolean isActive;


    @ManyToMany(fetch = FetchType.EAGER)
    private List<RoleEntity> role;

    @OneToMany
    private List<OfferEntity> offers;

    public UserEntity() {
    }

    public String getFirstName() {
        return firstName;
    }

    public boolean isActive() {
        return isActive;
    }

    public UserEntity setActive(boolean active) {
        isActive = active;
        return this;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getCityVillageName() {
        return cityVillageName;
    }

    public UserEntity setCityVillageName(String cityVillageName) {
        this.cityVillageName = cityVillageName;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public UserEntity setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserEntity setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<RoleEntity> getRole() {
        return role;
    }

    public UserEntity setRole(List<RoleEntity> role) {
        this.role = role;
        return this;
    }

    public List<OfferEntity> getOffers() {
        return offers;
    }

    public UserEntity setOffers(List<OfferEntity> offers) {
        this.offers = offers;
        return this;
    }
}
