package com.example.carssale.model.entity;

import com.example.carssale.model.entity.enums.TranssmissionEnum;

import javax.persistence.*;

@Entity
@Table(name = "car_transmission")
public class TransmissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private TranssmissionEnum transsmission;

    public TransmissionEntity() {
    }

    public Long getId() {
        return id;
    }

    public TransmissionEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public TranssmissionEnum getTranssmission() {
        return transsmission;
    }

    public TransmissionEntity setTranssmission(TranssmissionEnum transsmission) {
        this.transsmission = transsmission;
        return this;
    }
}
