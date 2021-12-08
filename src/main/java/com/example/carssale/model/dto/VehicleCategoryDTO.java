package com.example.carssale.model.dto;

import com.example.carssale.model.entity.enums.VehicleCategoryEnum;

public class VehicleCategoryDTO {

    private Long id;

    private VehicleCategoryEnum category;

    public VehicleCategoryDTO() {
    }

    public Long getId() {
        return id;
    }

    public VehicleCategoryDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public VehicleCategoryEnum getCategory() {
        return category;
    }

    public VehicleCategoryDTO setCategory(VehicleCategoryEnum category) {
        this.category = category;
        return this;
    }
}
