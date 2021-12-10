package com.example.carssale.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vehicle_models")
public class ModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelName;

    @ManyToOne
    private BrandEntity brand;

    @ManyToMany
    private List<FuelTypeEntity> fuelType;

    @ManyToMany
    private List<TransmissionEntity> transmission;

    @ManyToMany
    private List<VehicleCoupeEntity> vehicleCoupe;

    @ManyToMany
    private List<VehicleYearEntity> vehicleYear;

    public ModelEntity() {
    }

    public List<FuelTypeEntity> getFuelType() {
        return fuelType;
    }

    public List<VehicleYearEntity> getVehicleYear() {
        return vehicleYear;
    }

    public ModelEntity setVehicleYear(List<VehicleYearEntity> vehicleYear) {
        this.vehicleYear = vehicleYear;
        return this;
    }

    public ModelEntity setFuelType(List<FuelTypeEntity> fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    public List<TransmissionEntity> getTransmission() {
        return transmission;
    }

    public ModelEntity setTransmission(List<TransmissionEntity> transmission) {
        this.transmission = transmission;
        return this;
    }

    public List<VehicleCoupeEntity> getVehicleCoupe() {
        return vehicleCoupe;
    }

    public ModelEntity setVehicleCoupe(List<VehicleCoupeEntity> vehicleCoupe) {
        this.vehicleCoupe = vehicleCoupe;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ModelEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getModelName() {
        return modelName;
    }

    public ModelEntity setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public ModelEntity setBrand(BrandEntity brand) {
        this.brand = brand;
        return this;
    }
}
