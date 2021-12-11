package com.example.carssale.model.entity;

import com.example.carssale.model.entity.enums.*;

import javax.persistence.*;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    @ManyToOne
    private UserEntity user;

    private Integer doorCount;

    private String emissionClass;

    private Integer vehicleYear;

    private Integer price;

    private String modification;

    private Integer kilometer;

    private Integer power;

    @Column()
    @Enumerated(EnumType.STRING)
    private VehicleCoupeEnum carCoupe;

    @Column()
    @Enumerated(EnumType.STRING)
    private VehicleStatusEnum vehicleStatus;

    @Column
    @Enumerated(EnumType.STRING)
    private ExteriorColorEnum exteriorColor;

    @Column
    @Enumerated(EnumType.STRING)
    private FuelTypeEnum fuelType;

    @ManyToOne(fetch = FetchType.EAGER)
    private ModelEntity model;

    @OneToOne
    private OfferDescriptionEntity offerDescription;

    @Column
    @Enumerated(EnumType.STRING)
    private PriceTypeEnum priceType;

    @Column
    @Enumerated(EnumType.STRING)
    private TransmisionEnum transmission;


    public OfferEntity() {
    }

    public Integer getPower() {
        return power;
    }

    public OfferEntity setPower(Integer power) {
        this.power = power;
        return this;
    }

    public Integer getKilometer() {
        return kilometer;
    }

    public OfferEntity setKilometer(Integer kilometer) {
        this.kilometer = kilometer;
        return this;
    }

    public String getModification() {
        return modification;
    }

    public OfferEntity setModification(String modification) {
        this.modification = modification;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public OfferEntity setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public OfferEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public Integer getDoorCount() {
        return doorCount;
    }

    public OfferEntity setDoorCount(Integer doorCount) {
        this.doorCount = doorCount;
        return this;
    }

    public String getEmissionClass() {
        return emissionClass;
    }

    public OfferEntity setEmissionClass(String emissionClass) {
        this.emissionClass = emissionClass;
        return this;
    }

    public Integer getVehicleYear() {
        return vehicleYear;
    }

    public OfferEntity setVehicleYear(Integer vehicleYear) {
        this.vehicleYear = vehicleYear;
        return this;
    }

    public VehicleCoupeEnum getCarCoupe() {
        return carCoupe;
    }

    public OfferEntity setCarCoupe(VehicleCoupeEnum carCoupe) {
        this.carCoupe = carCoupe;
        return this;
    }

    public VehicleStatusEnum getVehicleStatus() {
        return vehicleStatus;
    }

    public OfferEntity setVehicleStatus(VehicleStatusEnum vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
        return this;
    }

    public ExteriorColorEnum getExteriorColor() {
        return exteriorColor;
    }

    public OfferEntity setExteriorColor(ExteriorColorEnum exteriorColor) {
        this.exteriorColor = exteriorColor;
        return this;
    }

    public FuelTypeEnum getFuelType() {
        return fuelType;
    }

    public OfferEntity setFuelType(FuelTypeEnum fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    public ModelEntity getModel() {
        return model;
    }

    public OfferEntity setModel(ModelEntity model) {
        this.model = model;
        return this;
    }

    public OfferDescriptionEntity getOfferDescription() {
        return offerDescription;
    }

    public OfferEntity setOfferDescription(OfferDescriptionEntity offerDescription) {
        this.offerDescription = offerDescription;
        return this;
    }

    public PriceTypeEnum getPriceType() {
        return priceType;
    }

    public OfferEntity setPriceType(PriceTypeEnum priceType) {
        this.priceType = priceType;
        return this;
    }

    public TransmisionEnum getTransmission() {
        return transmission;
    }

    public OfferEntity setTransmission(TransmisionEnum transmission) {
        this.transmission = transmission;
        return this;
    }
}
