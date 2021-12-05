package com.example.carssale.model.dto;

public class RegionDTO {

    private Long id;
    private String regionName;

    public RegionDTO() {
    }

    public Long getId() {
        return id;
    }

    public RegionDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRegionName() {
        return regionName;
    }

    public RegionDTO setRegionName(String regionName) {
        this.regionName = regionName;
        return this;
    }
}
