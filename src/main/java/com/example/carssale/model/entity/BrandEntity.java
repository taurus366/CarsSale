package com.example.carssale.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vehicle_brands")
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brandName;

    @ManyToOne
    private VehicleCategoryEntity category;

    public BrandEntity() {
    }

    public Long getId() {
        return id;
    }

    public BrandEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBrandName() {
        return brandName;
    }

    public BrandEntity setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    public VehicleCategoryEntity getCategory() {
        return category;
    }

    public BrandEntity setCategory(VehicleCategoryEntity category) {
        this.category = category;
        return this;
    }
}
