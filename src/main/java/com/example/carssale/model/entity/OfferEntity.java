package com.example.carssale.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private CarCategoryEntity carCategory;

    @ManyToOne
    private CarCoupeEntity carCoupe;

    @ManyToOne
    private CarStatusEntity carStatus;

    // I am not sure if it needs
    // or just write String about it.
//    private CarYearEnum carYearEnum;
    private String vehicleYear;

//    private DoorCountEnum doorCountEnum;
    private String doorCount;

//    private EmissionClassEnum emissionClassEnum;
    private String emissionClass;

    @ManyToOne
    private ExteriorColorEntity exteriorColor;

    @ManyToOne
    private FuelTypeEntity fuelType;

    @ManyToOne
    private PriceTypeEntity priceType;

    @ManyToOne
    private TranssmissionEntity transsmissionEnum;

    @OneToOne
    private OfferDescriptionEntity offerDescription;

    public OfferEntity() {
    }

    public UserEntity getUser() {
        return user;
    }

    public OfferEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public CarCategoryEntity getCarCategory() {
        return carCategory;
    }

    public OfferEntity setCarCategory(CarCategoryEntity carCategory) {
        this.carCategory = carCategory;
        return this;
    }

    public CarCoupeEntity getCarCoupe() {
        return carCoupe;
    }

    public OfferEntity setCarCoupe(CarCoupeEntity carCoupe) {
        this.carCoupe = carCoupe;
        return this;
    }

    public CarStatusEntity getCarStatus() {
        return carStatus;
    }

    public OfferEntity setCarStatus(CarStatusEntity carStatus) {
        this.carStatus = carStatus;
        return this;
    }

    public String getVehicleYear() {
        return vehicleYear;
    }

    public OfferEntity setVehicleYear(String vehicleYear) {
        this.vehicleYear = vehicleYear;
        return this;
    }

    public String getDoorCount() {
        return doorCount;
    }

    public OfferEntity setDoorCount(String doorCount) {
        this.doorCount = doorCount;
        return this;
    }

    public String getEmissionClass() {
        return emissionClass;
    }

    public OfferEntity setEmissionClass(String emissionClass) {
        this.emissionClass = emissionClass;
        return this;
    }

    public ExteriorColorEntity getExteriorColor() {
        return exteriorColor;
    }

    public OfferEntity setExteriorColor(ExteriorColorEntity exteriorColor) {
        this.exteriorColor = exteriorColor;
        return this;
    }

    public FuelTypeEntity getFuelType() {
        return fuelType;
    }

    public OfferEntity setFuelType(FuelTypeEntity fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    public PriceTypeEntity getPriceType() {
        return priceType;
    }

    public OfferEntity setPriceType(PriceTypeEntity priceType) {
        this.priceType = priceType;
        return this;
    }

    public TranssmissionEntity getTranssmissionEnum() {
        return transsmissionEnum;
    }

    public OfferEntity setTranssmissionEnum(TranssmissionEntity transsmissionEnum) {
        this.transsmissionEnum = transsmissionEnum;
        return this;
    }

    public OfferDescriptionEntity getOfferDescription() {
        return offerDescription;
    }

    public OfferEntity setOfferDescription(OfferDescriptionEntity offerDescription) {
        this.offerDescription = offerDescription;
        return this;
    }
}
