package com.example.carssale.model.entity;

import com.example.carssale.model.entity.enums.ExteriorColorEnum;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_exterior_color")
public class ExteriorColorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private ExteriorColorEnum exteriorColorEnum;

    public ExteriorColorEntity() {
    }

    public Long getId() {
        return id;
    }

    public ExteriorColorEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public ExteriorColorEnum getExteriorColorEnum() {
        return exteriorColorEnum;
    }

    public ExteriorColorEntity setExteriorColorEnum(ExteriorColorEnum exteriorColorEnum) {
        this.exteriorColorEnum = exteriorColorEnum;
        return this;
    }
}
