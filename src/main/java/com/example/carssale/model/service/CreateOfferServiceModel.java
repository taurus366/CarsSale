package com.example.carssale.model.service;

import com.example.carssale.model.entity.ModelEntity;
import com.example.carssale.model.entity.enums.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

public class CreateOfferServiceModel {


    private Integer doorCount;


    private String emissionClass;


    private Integer vehicleYear;


    private Integer price;


    private String modification;


    private Integer kilometer;


    private Integer power;


    private VehicleStatusEnum vehicleStatus;


    private String statusUsed;


    private VehicleCoupeEnum carCoupe;


    private ExteriorColorEnum exteriorColor;


    private FuelTypeEnum fuelType;


    private ModelEntity model;


    private PriceTypeEnum priceType;


    private TransmisionEnum transmission;


    private List<MultipartFile> picture = new ArrayList<>();


    private String brand;

    public CreateOfferServiceModel() {
    }

    public Integer getDoorCount() {
        return doorCount;
    }

    public CreateOfferServiceModel setDoorCount(Integer doorCount) {
        this.doorCount = doorCount;
        return this;
    }

    public String getEmissionClass() {
        return emissionClass;
    }

    public CreateOfferServiceModel setEmissionClass(String emissionClass) {
        this.emissionClass = emissionClass;
        return this;
    }

    public Integer getVehicleYear() {
        return vehicleYear;
    }

    public CreateOfferServiceModel setVehicleYear(Integer vehicleYear) {
        this.vehicleYear = vehicleYear;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public CreateOfferServiceModel setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public String getModification() {
        return modification;
    }

    public CreateOfferServiceModel setModification(String modification) {
        this.modification = modification;
        return this;
    }

    public Integer getKilometer() {
        return kilometer;
    }

    public CreateOfferServiceModel setKilometer(Integer kilometer) {
        this.kilometer = kilometer;
        return this;
    }

    public Integer getPower() {
        return power;
    }

    public CreateOfferServiceModel setPower(Integer power) {
        this.power = power;
        return this;
    }

    public VehicleStatusEnum getVehicleStatus() {
        return vehicleStatus;
    }

    public CreateOfferServiceModel setVehicleStatus(VehicleStatusEnum vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
        return this;
    }

    public String getStatusUsed() {
        return statusUsed;
    }

    public CreateOfferServiceModel setStatusUsed(String statusUsed) {
        this.statusUsed = statusUsed;
        return this;
    }

    public VehicleCoupeEnum getCarCoupe() {
        return carCoupe;
    }

    public CreateOfferServiceModel setCarCoupe(VehicleCoupeEnum carCoupe) {
        this.carCoupe = carCoupe;
        return this;
    }

    public ExteriorColorEnum getExteriorColor() {
        return exteriorColor;
    }

    public CreateOfferServiceModel setExteriorColor(ExteriorColorEnum exteriorColor) {
        this.exteriorColor = exteriorColor;
        return this;
    }

    public FuelTypeEnum getFuelType() {
        return fuelType;
    }

    public CreateOfferServiceModel setFuelType(FuelTypeEnum fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    public ModelEntity getModel() {
        return model;
    }

    public CreateOfferServiceModel setModel(ModelEntity model) {
        this.model = model;
        return this;
    }

    public PriceTypeEnum getPriceType() {
        return priceType;
    }

    public CreateOfferServiceModel setPriceType(PriceTypeEnum priceType) {
        this.priceType = priceType;
        return this;
    }

    public TransmisionEnum getTransmission() {
        return transmission;
    }

    public CreateOfferServiceModel setTransmission(TransmisionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public List<MultipartFile> getPicture() {
        return picture;
    }

    public CreateOfferServiceModel setPicture(List<MultipartFile> picture) {
        this.picture = picture;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public CreateOfferServiceModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }
}
