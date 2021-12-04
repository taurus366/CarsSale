package com.example.carssale.model.entity;

import com.example.carssale.model.entity.enums.CarCategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "car_category")
public class CarCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private CarCategoryEnum carCategoryEnum;

    public CarCategoryEntity() {
    }

    public Long getId() {
        return id;
    }

    public CarCategoryEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public CarCategoryEnum getCarCategoryEnum() {
        return carCategoryEnum;
    }

    public CarCategoryEntity setCarCategoryEnum(CarCategoryEnum carCategoryEnum) {
        this.carCategoryEnum = carCategoryEnum;
        return this;
    }
}
