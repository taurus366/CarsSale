package com.example.carssale.model.entity;

import com.example.carssale.model.entity.enums.VehicleCategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_category")
public class VehicleCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private VehicleCategoryEnum vehicleCategoryName;

    public VehicleCategoryEntity() {
    }

    public Long getId() {
        return id;
    }

    public VehicleCategoryEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public VehicleCategoryEnum getVehicleCategoryName() {
        return vehicleCategoryName;
    }

    public VehicleCategoryEntity setVehicleCategoryName(VehicleCategoryEnum vehicleCategoryName) {
        this.vehicleCategoryName = vehicleCategoryName;
        return this;
    }
}
