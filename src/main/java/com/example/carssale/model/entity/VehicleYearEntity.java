package com.example.carssale.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_year")
public class VehicleYearEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer vehicleYear;

//    @ManyToOne
//    private ModelEntity model;

    public VehicleYearEntity() {
    }

//    public ModelEntity getModel() {
//        return model;
//    }
//
//    public VehicleYearEntity setModel(ModelEntity model) {
//        this.model = model;
//        return this;
//    }

    public Long getId() {
        return id;
    }

    public VehicleYearEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getVehicleYear() {
        return vehicleYear;
    }

    public VehicleYearEntity setVehicleYear(Integer vehicleYear) {
        this.vehicleYear = vehicleYear;
        return this;
    }
}
