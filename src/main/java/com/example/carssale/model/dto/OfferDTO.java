package com.example.carssale.model.dto;

import com.example.carssale.model.entity.PictureEntity;
import com.example.carssale.model.entity.enums.ExteriorColorEnum;
import com.example.carssale.model.entity.enums.FuelTypeEnum;
import com.example.carssale.model.entity.enums.VehicleCoupeEnum;
import com.example.carssale.model.entity.enums.VehicleStatusEnum;

import java.util.List;

public class OfferDTO {

    private Long id;
    private Integer doorCount;
    private String emissionClass;
    private Integer vehicleYear;
    private VehicleCoupeEnum carCoupe;
    private VehicleStatusEnum vehicleStatus;
    private ExteriorColorEnum exteriorColor;
    private FuelTypeEnum fuelType;
    private String model;
    private String priceType;
    private String transmission;
    private String brand;
    private String modification;
    private Integer price;
    private Integer kilometer;
    private String from;
    private Integer power;
    private List<PictureEntity> pictures;

    public OfferDTO() {
    }

    public List<PictureEntity> getPictures() {
        return pictures;
    }

    public OfferDTO setPictures(List<PictureEntity> pictures) {
        this.pictures = pictures;
        return this;
    }

    public Integer getPower() {
        return power;
    }

    public OfferDTO setPower(Integer power) {
        this.power = power;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public OfferDTO setFrom(String from) {
        this.from = from;
        return this;
    }

    public Integer getKilometer() {
        return kilometer;
    }

    public OfferDTO setKilometer(Integer kilometer) {
        this.kilometer = kilometer;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public OfferDTO setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public String getModification() {
        return modification;
    }

    public OfferDTO setModification(String modification) {
        this.modification = modification;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public OfferDTO setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public Long getId() {
        return id;
    }

    public OfferDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getDoorCount() {
        return doorCount;
    }

    public OfferDTO setDoorCount(Integer doorCount) {
        this.doorCount = doorCount;
        return this;
    }

    public String getEmissionClass() {
        return emissionClass;
    }

    public OfferDTO setEmissionClass(String emissionClass) {
        this.emissionClass = emissionClass;
        return this;
    }

    public Integer getVehicleYear() {
        return vehicleYear;
    }

    public OfferDTO setVehicleYear(Integer vehicleYear) {
        this.vehicleYear = vehicleYear;
        return this;
    }

    public VehicleCoupeEnum getCarCoupe() {
        return carCoupe;
    }

    public OfferDTO setCarCoupe(VehicleCoupeEnum carCoupe) {
        this.carCoupe = carCoupe;
        return this;
    }

    public VehicleStatusEnum getVehicleStatus() {
        return vehicleStatus;
    }

    public OfferDTO setVehicleStatus(VehicleStatusEnum vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
        return this;
    }

    public ExteriorColorEnum getExteriorColor() {
        return exteriorColor;
    }

    public OfferDTO setExteriorColor(ExteriorColorEnum exteriorColor) {
        this.exteriorColor = exteriorColor;
        return this;
    }

    public FuelTypeEnum getFuelType() {
        return fuelType;
    }

    public OfferDTO setFuelType(FuelTypeEnum fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public String getPriceType() {
        return priceType;
    }

    public OfferDTO setPriceType(String priceType) {
        this.priceType = priceType;
        return this;
    }

    public String getTransmission() {
        return transmission;
    }

    public OfferDTO setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }
}
