package com.example.carssale.model.service;

public class FeatureServiceModel {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public FeatureServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public FeatureServiceModel setName(String name) {
        this.name = name;
        return this;
    }
}
