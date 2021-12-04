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



    public RegionEntity() {
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
