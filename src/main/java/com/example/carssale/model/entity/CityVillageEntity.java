package com.example.carssale.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "cities_villages")
public class CityVillageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cityVillageName;

    @ManyToOne(cascade = CascadeType.DETACH)
    private RegionEntity region;

    public CityVillageEntity() {
    }

    public Long getId() {
        return id;
    }

    public CityVillageEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCityVillageName() {
        return cityVillageName;
    }

    public CityVillageEntity setCityVillageName(String cityVillageName) {
        this.cityVillageName = cityVillageName;
        return this;
    }

    public RegionEntity getRegion() {
        return region;
    }

    public CityVillageEntity setRegion(RegionEntity region) {
        this.region = region;
        return this;
    }
}
