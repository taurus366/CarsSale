package com.example.carssale.model.entity;

import com.example.carssale.model.entity.enums.VehicleCoupeEnum;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_coupe_type")
public class VehicleCoupeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private VehicleCoupeEnum vehicleCoupe;

    public VehicleCoupeEntity() {
    }

    public VehicleCoupeEnum getVehicleCoupe() {
        return vehicleCoupe;
    }

    public VehicleCoupeEntity setVehicleCoupe(VehicleCoupeEnum vehicleCoupe) {
        this.vehicleCoupe = vehicleCoupe;
        return this;
    }

    public Long getId() {
        return id;
    }

    public VehicleCoupeEntity setId(Long id) {
        this.id = id;
        return this;
    }
}
