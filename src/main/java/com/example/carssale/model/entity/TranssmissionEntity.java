package com.example.carssale.model.entity;

import com.example.carssale.model.entity.enums.TranssmissionEnum;

import javax.persistence.*;

@Entity
@Table(name = "car_transsmission")
public class TranssmissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private TranssmissionEnum transsmission;

    public TranssmissionEntity() {
    }

    public Long getId() {
        return id;
    }

    public TranssmissionEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public TranssmissionEnum getTranssmission() {
        return transsmission;
    }

    public TranssmissionEntity setTranssmission(TranssmissionEnum transsmission) {
        this.transsmission = transsmission;
        return this;
    }
}
