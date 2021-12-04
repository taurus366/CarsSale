package com.example.carssale.model.entity;

import com.example.carssale.model.entity.enums.PriceTypeEnum;

import javax.persistence.*;

@Entity
@Table(name = "price_type")
public class PriceTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private PriceTypeEnum priceType;

    public PriceTypeEntity() {
    }

    public Long getId() {
        return id;
    }

    public PriceTypeEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public PriceTypeEnum getPriceType() {
        return priceType;
    }

    public PriceTypeEntity setPriceType(PriceTypeEnum priceType) {
        this.priceType = priceType;
        return this;
    }
}
