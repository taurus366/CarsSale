package com.example.carssale.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "regions")
public class RegionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String regionName;

    @OneToMany(mappedBy = "region",cascade = CascadeType.ALL)
    private List<CityVillageEntity> cityVillages;

    public RegionEntity() {
    }

    public List<CityVillageEntity> getCityVillages() {
        return cityVillages;
    }

    public RegionEntity setCityVillages(List<CityVillageEntity> cityVillages) {
        this.cityVillages = cityVillages;
        return this;
    }

    public Long getId() {
        return id;
    }

    public RegionEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRegionName() {
        return regionName;
    }

    public RegionEntity setRegionName(String regionName) {
        this.regionName = regionName;
        return this;
    }

}
