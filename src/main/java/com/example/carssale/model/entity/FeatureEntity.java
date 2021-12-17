package com.example.carssale.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "features")
public class FeatureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public FeatureEntity() {
    }

    public Long getId() {
        return id;
    }

    public FeatureEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public FeatureEntity setName(String name) {
        this.name = name;
        return this;
    }
}
