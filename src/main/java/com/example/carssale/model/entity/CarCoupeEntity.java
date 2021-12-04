package com.example.carssale.model.entity;

import com.example.carssale.model.entity.enums.CarCoupeEnum;

import javax.persistence.*;

@Entity
@Table(name = "car_coupe_type")
public class CarCoupeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private CarCoupeEnum carCoupe;

    public CarCoupeEntity() {
    }

    public CarCoupeEnum getCarCoupe() {
        return carCoupe;
    }

    public CarCoupeEntity setCarCoupe(CarCoupeEnum carCoupe) {
        this.carCoupe = carCoupe;
        return this;
    }

    public Long getId() {
        return id;
    }

    public CarCoupeEntity setId(Long id) {
        this.id = id;
        return this;
    }
}
