package com.example.carssale.model.entity;

import com.example.carssale.model.entity.enums.FuelTypeEnum;

import javax.persistence.*;

@Entity
@Table(name = "fuel_type")
public class FuelTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private FuelTypeEnum name;

    public FuelTypeEntity() {
    }

    public Long getId() {
        return id;
    }

    public FuelTypeEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public FuelTypeEnum getName() {
        return name;
    }

    public FuelTypeEntity setName(FuelTypeEnum name) {
        this.name = name;
        return this;
    }
}
