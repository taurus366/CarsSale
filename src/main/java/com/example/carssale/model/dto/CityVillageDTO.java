package com.example.carssale.model.dto;

public class CityVillageDTO {

    private Long id;
    private String cityVillageName;

    public CityVillageDTO() {
    }

    public Long getId() {
        return id;
    }

    public CityVillageDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCityVillageName() {
        return cityVillageName;
    }

    public CityVillageDTO setCityVillageName(String cityVillageName) {
        this.cityVillageName = cityVillageName;
        return this;
    }
}
