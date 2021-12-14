package com.example.carssale.model.binding;

import com.example.carssale.model.entity.enums.ExteriorColorEnum;
import com.example.carssale.model.entity.enums.PriceTypeEnum;
import com.example.carssale.model.entity.enums.VehicleStatusEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class OfferEditBindingModel {

    @NotNull
    @NotBlank
    private String modification;

    @NotNull
    @Positive
    private Integer power;

    @NotNull
    @Positive
    private Integer kilometer;

    @NotNull
    @Positive
    private Integer price;

    @NotNull
    private PriceTypeEnum priceType;

    @NotNull
    private VehicleStatusEnum vehicleStatus;

    @NotNull
    private ExteriorColorEnum exteriorColor;

    public String getModification() {
        return modification;
    }

    public OfferEditBindingModel setModification(String modification) {
        this.modification = modification;
        return this;
    }

    public Integer getPower() {
        return power;
    }

    public OfferEditBindingModel setPower(Integer power) {
        this.power = power;
        return this;
    }

    public Integer getKilometer() {
        return kilometer;
    }

    public OfferEditBindingModel setKilometer(Integer kilometer) {
        this.kilometer = kilometer;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public OfferEditBindingModel setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public PriceTypeEnum getPriceType() {
        return priceType;
    }

    public OfferEditBindingModel setPriceType(PriceTypeEnum priceType) {
        this.priceType = priceType;
        return this;
    }

    public VehicleStatusEnum getVehicleStatus() {
        return vehicleStatus;
    }

    public OfferEditBindingModel setVehicleStatus(VehicleStatusEnum vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
        return this;
    }

    public ExteriorColorEnum getExteriorColor() {
        return exteriorColor;
    }

    public OfferEditBindingModel setExteriorColor(ExteriorColorEnum exteriorColor) {
        this.exteriorColor = exteriorColor;
        return this;
    }
}
