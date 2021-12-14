package com.example.carssale.model.service;

import com.example.carssale.model.entity.enums.ExteriorColorEnum;
import com.example.carssale.model.entity.enums.PriceTypeEnum;
import com.example.carssale.model.entity.enums.VehicleStatusEnum;

public class OfferEditServiceModel {


    private String modification;


    private Integer power;


    private Integer kilometer;


    private Integer price;


    private PriceTypeEnum priceType;


    private VehicleStatusEnum vehicleStatus;


    private ExteriorColorEnum exteriorColor;

    public String getModification() {
        return modification;
    }

    public OfferEditServiceModel setModification(String modification) {
        this.modification = modification;
        return this;
    }

    public Integer getPower() {
        return power;
    }

    public OfferEditServiceModel setPower(Integer power) {
        this.power = power;
        return this;
    }

    public Integer getKilometer() {
        return kilometer;
    }

    public OfferEditServiceModel setKilometer(Integer kilometer) {
        this.kilometer = kilometer;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public OfferEditServiceModel setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public PriceTypeEnum getPriceType() {
        return priceType;
    }

    public OfferEditServiceModel setPriceType(PriceTypeEnum priceType) {
        this.priceType = priceType;
        return this;
    }

    public VehicleStatusEnum getVehicleStatus() {
        return vehicleStatus;
    }

    public OfferEditServiceModel setVehicleStatus(VehicleStatusEnum vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
        return this;
    }

    public ExteriorColorEnum getExteriorColor() {
        return exteriorColor;
    }

    public OfferEditServiceModel setExteriorColor(ExteriorColorEnum exteriorColor) {
        this.exteriorColor = exteriorColor;
        return this;
    }
}
