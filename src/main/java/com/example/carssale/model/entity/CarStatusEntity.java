package com.example.carssale.model.entity;

import com.example.carssale.model.entity.enums.CarStatusEnum;

import javax.persistence.*;

@Entity
@Table(name = "car_status")
public class CarStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private CarStatusEnum carStatus;

    public CarStatusEntity() {
    }

    public Long getId() {
        return id;
    }

    public CarStatusEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public CarStatusEnum getCarStatus() {
        return carStatus;
    }

    public CarStatusEntity setCarStatus(CarStatusEnum carStatus) {
        this.carStatus = carStatus;
        return this;
    }
}
