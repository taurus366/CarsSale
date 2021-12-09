package com.example.carssale.model.dto;

import com.example.carssale.model.entity.*;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

public class ModelDTO {

    private Long id;
    private String modelName;
    private List<FuelTypeEntity> fuelType;
    private List<TransmissionEntity> transmission;
    private List<VehicleCoupeEntity> vehicleCoupe;
    private List<VehicleYearEntity> vehicleYear;

    public ModelDTO() {
    }

    public Long getId() {
        return id;
    }

    public ModelDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getModelName() {
        return modelName;
    }

    public ModelDTO setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public List<FuelTypeEntity> getFuelType() {
        return fuelType;
    }

    public ModelDTO setFuelType(List<FuelTypeEntity> fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    public List<TransmissionEntity> getTransmission() {
        return transmission;
    }

    public ModelDTO setTransmission(List<TransmissionEntity> transmission) {
        this.transmission = transmission;
        return this;
    }

    public List<VehicleCoupeEntity> getVehicleCoupe() {
        return vehicleCoupe;
    }

    public ModelDTO setVehicleCoupe(List<VehicleCoupeEntity> vehicleCoupe) {
        this.vehicleCoupe = vehicleCoupe;
        return this;
    }

    public List<VehicleYearEntity> getVehicleYear() {
        return vehicleYear;
    }

    public ModelDTO setVehicleYear(List<VehicleYearEntity> vehicleYear) {
        this.vehicleYear = vehicleYear;
        return this;
    }
}
