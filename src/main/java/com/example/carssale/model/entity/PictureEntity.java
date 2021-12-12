package com.example.carssale.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pictures")
public class PictureEntity extends BaseEntity{

    private String url;

    private String publicId;

//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
//    private OfferEntity offerEntity;

    public PictureEntity() {
    }

//    public OfferEntity getOfferEntity() {
//        return offerEntity;
//    }
//
//    public PictureEntity setOfferEntity(OfferEntity offerEntity) {
//        this.offerEntity = offerEntity;
//        return this;
//    }

    public String getUrl() {
        return url;
    }

    public PictureEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPublicId() {
        return publicId;
    }

    public PictureEntity setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }
}
