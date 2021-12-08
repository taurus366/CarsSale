package com.example.carssale.model.dto;

public class BrandDTO {

    private Long id;
    private String brandName;

    public BrandDTO() {
    }

    public Long getId() {
        return id;
    }

    public BrandDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBrandName() {
        return brandName;
    }

    public BrandDTO setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }
}
