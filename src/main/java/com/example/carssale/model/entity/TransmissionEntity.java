package com.example.carssale.model.entity;

import com.example.carssale.model.entity.enums.TransmisionEnum;

import javax.persistence.*;

@Entity
@Table(name = "car_transmission")
public class TransmissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private TransmisionEnum transmission;

    public TransmissionEntity() {
    }

    public Long getId() {
        return id;
    }

    public TransmissionEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public TransmisionEnum getTransmission() {
        return transmission;
    }

    public TransmissionEntity setTransmission(TransmisionEnum transmission) {
        this.transmission = transmission;
        return this;
    }
}
