package com.example.carssale.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "offer_descriptions")
public class OfferDescriptionEntity extends BaseEntity{

    @Column(columnDefinition = "LONGTEXT")
    private String description;

    public OfferDescriptionEntity() {
    }

    public String getDescription() {
        return description;
    }

    public OfferDescriptionEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
